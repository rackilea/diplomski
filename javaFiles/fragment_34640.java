#!/usr/bin/perl -w

use strict;
use Net::Jabber;
use threads;
use DBI;

my $server = shift @ARGV;
my $port = shift @ARGV;
my $username = shift @ARGV;
my $password = shift @ARGV;
my $resource = shift @ARGV;
my $chatroom = shift @ARGV;

my %img = ('URGENT' => 'urgent.png',
            'HIGH' => 'high.png',
            'MEDIUM' => 'medium.png',
            'LOW' => 'low.png');

my $dbname_status= 'db';
my $dbuser_status= 'user';
my $dbpass_status= 'pass';
my $dbhost_status = 'localhost';
my $dbport_status = 5432;

my $dbh_status = DBI->connect("dbi:Pg:dbname=$dbname_status;host=$dbhost_status;port=$dbport_status", $dbuser_status, $dbpass_status, {AutoCommit => 0, RaiseError => 1});
my $sth_status = $dbh_status->prepare(qq{SELECT * FROM sosrhs_ticketstatus});
$sth_status->execute;
my %status = ();
while (my $res = $sth_status->fetchrow_hashref)
{
    $status{$res->{status}} = $res->{id};
}
$sth_status->finish;
$dbh_status->disconnect;

print "\nSERVER: ", $server, "\n";
print 'PORT: ', $port, "\n";
print 'USERNAME: ', $username, "\n";
print 'RESOURCE: ', $resource, "\n";


$SIG{HUP} = \&Stop;
$SIG{KILL} = \&Stop;
$SIG{TERM} = \&Stop;
$SIG{INT} = \&Stop;

my $Connection = new Net::Jabber::Client();

$Connection->SetCallBacks(message => sub {threads->create('InMessage', (@_))->join()},
                          presence => sub {threads->create('InPresence', (@_))->join()},
                          iq => sub {threads->create('InIQ', (@_))->join()}
                          );

my $status = $Connection->Connect(hostname=>$server,
                                  port=>$port,
                                 );

if (!(defined($status)))
{
    print "ERROR:  Jabber server is down or connection was not allowed.\n";
    print "        ($!)\n";
    exit(0);
}

my @result = $Connection->AuthSend(username=>$username,
                                   password=>$password,
                                   resource=>$resource);

if ($result[0] ne "ok")
{
    print "ERROR: Authorization failed: $result[0] - $result[1]\n";
    exit(0);
}

print "Logged in to $server:$port...\n";

$Connection->RosterGet();

print "Getting Roster to tell server to send presence info...\n";

$Connection->PresenceSend();

print "Sending presence to tell world that we are logged in...\n";

$Connection->MUCJoin(room => $chatroom,
                    server => 'conference.' . $server,
                    nick => $username);

print 'Join ' . $chatroom . '@conference.sosrhs MUC room...';
print "\n";

while(defined($Connection->Process())) { }

print "ERROR: The connection was killed...\n";

exit(0);


sub Stop
{
    print "Exiting...\n";
    $Connection->Disconnect();
    exit(0);
}


sub InMessage
{
    my $sid = shift;
    my $message = shift;

    my $type = $message->GetType();
    my $fromJID = $message->GetFrom("jid");

    my $from = $fromJID->GetUserID();
    my $resource = $fromJID->GetResource();
    my $subject = $message->GetSubject();
    my $body = $message->GetBody();
    #print "===\n";
    #print "Message ($type)\n";
    #print "  From: $from ($resource)\n";
    #print "  Subject: $subject\n";
    #print "  Body: $body\n";
    #print "===\n";
    #print $message->GetXML(),"\n";
    #print "===\n";

    if ($from eq 'ticket_distributor')
    {
        if ($body =~ /^ticketrelay /)
        {
            &to_group($body);
        }
        elsif ($body =~ /^ackrelay /)
        {
            &to_group_ack($body);
        }
        elsif ($body =~ /^ticketupdaterelay /)
        {
            &to_group_update($body);
        }
        elsif ($body =~ /^ticketwithdrawrelay /)
        {
            &to_group_withdraw($body);
        }
        elsif ($body =~ /^ticketclearrelay /)
        {
            &to_group_clear($body);
        }
        elsif ($body =~ /^ticketcloserelay /)
        {
            &to_group_close($body);
        }
        elsif ($body =~ /^ticketfwdrelay /)
        {
            &to_group_fwd($body);
        }
    }
    else
    {
        if ($body =~ /^ticketnew /)
        {
            &to_group($body);
            &to_ticket_distributor($body);
        }
        elsif ($body =~ /^ack /)
        {
            &to_ticket_distributor_ack($body);
        }
        elsif ($body =~ /^ticketupdate /)
        {
            &to_ticket_distributor_update($body);
        }
        elsif ($body =~ /^ticketwithdraw /)
        {
            &to_ticket_distributor_withdraw($body);
        }
        elsif ($body =~ /^ticketclear /)
        {
            &to_ticket_distributor_clear($body);
        }
        elsif ($body =~ /^ticketclose /)
        {
            &to_ticket_distributor_close($body);
        }
        elsif ($body =~ /^ticketfwd /)
        {
            &to_ticket_distributor_fwd($body);
        }
    }
}


sub InIQ
{
    my $sid = shift;
    my $iq = shift;

    my $from = $iq->GetFrom();
    my $type = $iq->GetType();
    my $query = $iq->GetQuery();
    my $xmlns = $query->GetXMLNS();
    #print "===\n";
    #print "IQ\n";
    #print "  From $from\n";
    #print "  Type: $type\n";
    #print "  XMLNS: $xmlns";
    #print "===\n";
    #print $iq->GetXML(),"\n";
    #print "===\n";
}

sub InPresence
{
    my $sid = shift;
    my $presence = shift;

    my $from = $presence->GetFrom();
    my $type = $presence->GetType();
    my $status = $presence->GetStatus();
    #print "===\n";
    #print "Presence\n";
    #print "  From $from\n";
    #print "  Type: $type\n";
    #print "  Status: $status\n";
    #print "===\n";
    #print $presence->GetXML(),"\n";
    #print "===\n";

    if ($type eq 'subscribe')
    {
        my @usrreq = split('@', $from);
        my $usrreq = $usrreq[0] . '@' . $server;
        $Connection->Subscription(type => 'subscribed',
                                    to => $usrreq
                                    );
    }
}

# Functions for actions taken upon ticket
sub to_ticket_distributor
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($msg[1]);
    my $group_assigned_groupnamechat = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $group_assigned_groupnamechat = $res->{group_assigned_groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => $msg[1] . ' ' . $group_assigned_groupnamechat);
}

sub to_ticket_distributor_ack
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1] $msg[2]\n";
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->do(qq{UPDATE sosrhs_tickets SET ticketstatus = $status{'WORK IN PROGRESS'}, user_accepted = '$msg[2]', tmstmp_accepted = now() WHERE ticket_id = $msg[1]});
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($msg[1]);
    my $user_creator_groups_id = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groups_id = $res->{user_creator_groups_id};
    }
    $sth->finish;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = ?});
    $sth->execute($user_creator_groups_id);
    my $user_creator_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ackrelay ' . $msg[1] . ' ' . $user_creator_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ackfinish ' . $msg[1]);
}

sub to_ticket_distributor_update
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1] $msg[2]\n";
    my $ticket_action = shift @msg;
    my $ticket_id = shift @msg;
    my $user_id_update = shift @msg;
    my $ticket_comment = join(' ', @msg);
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->prepare(qq{INSERT INTO sosrhs_tickets_comments (ticket_id, users_id, comment) VALUES (?, ?, ?)});
    $sth->execute($ticket_id, $user_id_update, $ticket_comment);
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($ticket_id);
    my $user_creator_groups_id = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groups_id = $res->{user_creator_groups_id};
    }
    $sth->finish;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = ?});
    $sth->execute($user_creator_groups_id);
    my $user_creator_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketupdaterelay ' . $ticket_id . ' ' . $user_creator_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketupdatefinish ' . $ticket_id);
}

sub to_ticket_distributor_withdraw
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";
    my $ticket_action = shift @msg;
    my $ticket_id = shift @msg;
    my $user_id_withdraw = shift @msg;
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->do(qq{UPDATE sosrhs_tickets SET ticketstatus = $status{'WITHDRAWN'}, user_withdrawn = $user_id_withdraw, tmstmp_withdrawn = now() WHERE ticket_id = $ticket_id});
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($ticket_id);
    my $user_creator_groups_id = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groups_id = $res->{user_creator_groups_id};
    }
    $sth->finish;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = ?});
    $sth->execute($user_creator_groups_id);
    my $user_creator_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketwithdrawrelay ' . $ticket_id . ' ' . $user_creator_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketwithdrawfinish ' . $ticket_id);
}

sub to_ticket_distributor_clear
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";
    my $ticket_action = shift @msg;
    my $ticket_id = shift @msg;
    my $user_id_clear = shift @msg;
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->do(qq{UPDATE sosrhs_tickets SET ticketstatus = $status{'CLEARED'}, user_cleared = $user_id_clear, tmstmp_cleared = now() WHERE ticket_id = $ticket_id});
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($ticket_id);
    my $user_creator_groups_id = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groups_id = $res->{user_creator_groups_id};
    }
    $sth->finish;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = ?});
    $sth->execute($user_creator_groups_id);
    my $user_creator_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketclearrelay ' . $ticket_id . ' ' . $user_creator_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketclearfinish ' . $ticket_id);
}

sub to_ticket_distributor_close
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";
    my $ticket_action = shift @msg;
    my $ticket_id = shift @msg;
    my $user_id_close = shift @msg;
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->do(qq{UPDATE sosrhs_tickets SET ticketstatus = $status{'CLOSED'}, user_closed = $user_id_close, tmstmp_closed = now() WHERE ticket_id = $ticket_id});
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_users_v WHERE groups_id = (SELECT group_assigned_id FROM sosrhs_tickets_v WHERE ticket_id = ?)});
    $sth->execute($ticket_id);
    my $user_accepted_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_accepted_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketcloserelay ' . $ticket_id . ' ' . $user_accepted_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketclosefinish ' . $ticket_id);
}

sub to_ticket_distributor_fwd
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1] $msg[2]\n";
    my $ticket_action = shift @msg;
    my $ticket_id = shift @msg;
    my $user_id_fwd = shift @msg;
    my $group_id_fwd_to = shift @msg;
    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->do(qq{UPDATE sosrhs_tickets SET ticketstatus = $status{'ASSIGNED'}, user_accepted = NULL, tmstmp_accepted = NULL, group_assigned = $group_id_fwd_to WHERE ticket_id = $ticket_id});
    $dbh->commit;

    $sth = $dbh->prepare(qq{INSERT INTO sosrhs_tickets_comments (ticket_id, users_id, groups_id_fwd_to) VALUES (?, ?, ?)});
    $sth->execute($ticket_id, $user_id_fwd, $group_id_fwd_to);
    $dbh->commit;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = (SELECT group_assigned_id FROM sosrhs_tickets_v WHERE ticket_id = ?)});
    $sth->execute($ticket_id);
    my $user_fwd_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_fwd_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $sth = $dbh->prepare(qq{SELECT groupnamechat FROM sosrhs_groups WHERE id = (SELECT user_creator_groups_id FROM sosrhs_tickets_v WHERE ticket_id = ?)});
    $sth->execute($ticket_id);
    my $user_creator_groupchatname = '';
    while (my $res = $sth->fetchrow_hashref)
    {
        $user_creator_groupchatname = $res->{groupnamechat};
    }
    $sth->finish;

    $dbh->disconnect;

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketfwdrelay ' . $ticket_id . ' ' . $user_fwd_groupchatname);

    $Connection->MessageSend(to => 'ticket_distributor@' . $server,
                            type => 'chat',
                            body => 'ticketfwdrelay ' . $ticket_id . ' ' . $user_creator_groupchatname);

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketfwdfinish ' . $ticket_id);
}

# Functions for relayed actions from ticket_distributor
sub to_group
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => &build_new_ticket_message($msg[1]));
}

sub to_group_ack
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ackrelay ' . $msg[1]);
}

sub to_group_update
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketupdaterelay ' . $msg[1]);
}

sub to_group_withdraw
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketwithdrawrelay ' . $msg[1]);
}

sub to_group_clear
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketclearrelay ' . $msg[1]);
}

sub to_group_close
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketcloserelay ' . $msg[1]);
}

sub to_group_fwd
{
    my $msg = shift;
    my @msg = split(' ', $msg);
    print "\n$username : $msg[0] $msg[1]\n";

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => 'ticketfwdrelay ' . $msg[1]);

    sleep 2;

    $Connection->MessageSend(to => $chatroom . '@conference.' . $server,
                            type => 'groupchat',
                            body => &build_new_ticket_message($msg[1]));
}

sub build_new_ticket_message
{
    my $ticket_id = shift;

    my $dbname= 'db';
    my $dbuser= 'user';
    my $dbpass= 'pass';
    my $dbhost = 'localhost';
    my $dbport = 5432;

    my $dbh = DBI->connect("dbi:Pg:dbname=$dbname;host=$dbhost;port=$dbport", $dbuser, $dbpass, {AutoCommit => 0, RaiseError => 1});
    my $sth = $dbh->prepare(qq{SELECT * FROM sosrhs_tickets_v where ticket_id = ?});
    $sth->execute($ticket_id);
    my %ticket = ();
    while (my $res = $sth->fetchrow_hashref)
    {
        $ticket{ticket_id} = $res->{ticket_id};
        $ticket{ticketcategory_category} = $res->{ticketcategory_category};
        $ticket{ticketstatus_status} = $res->{ticketstatus_status};
        $ticket{ticketpriority_severityname} = $res->{ticketpriority_severityname};
        $ticket{tmstmp_assigned} = $res->{tmstmp_assigned};
        $ticket{user_creator_firstname} = $res->{user_creator_firstname};
        $ticket{user_creator_secondname} = $res->{user_creator_secondname};
        $ticket{group_assigned_groupname} = $res->{group_assigned_groupname};
        $ticket{ticket_text} = $res->{ticket_text};
        $ticket{ticket_file} = $res->{ticket_file};
        $ticket{subject} = $res->{subject};
        $ticket{user_creator_groups_id} = $res->{user_creator_groups_id};
    }
    $sth->finish;

    $dbh->disconnect;

    my $html_msg = q!<p id="p! . $ticket{ticket_id} . q!">
                        <img src="/sosrhs/images/! . $img{$ticket{ticketpriority_severityname}} . q!"/>&nbsp;<text id="t! . $ticket{ticket_id} . q!" class="textmainleft">! . substr($ticket{tmstmp_assigned}, 0, 16) . '&nbsp;|&nbsp;' . $ticket{ticketstatus_status} . '&nbsp;|&nbsp;' . $ticket{ticketcategory_category} . '&nbsp;|&nbsp;' . $ticket{subject} . '<br>From:&nbsp;' . $ticket{user_creator_firstname} . '&nbsp;' . $ticket{user_creator_secondname} . '&nbsp;|&nbsp;To:&nbsp;' . $ticket{group_assigned_groupname} . q!</text>&nbsp;|&nbsp;<a href="#" onClick="$('#explanation').fadeOut('fast'); $('div.divmainleft > p').css('background-color', 'white'); $('#p! . $ticket{ticket_id} . q!').css('background-color', '#E0E0F8'); $('#tdexplanation').load('/cgi-bin/sosrhs/ticket_details.pl?ticket_id=! . $ticket{ticket_id} . q!&my_groupchatname=! . $chatroom . q!');">Details</a>
                    </p>!;

                    #<hr id="h! . $ticket{ticket_id} . q!" style="height: 1px; border-width: 0; color: gray; background-color: gray;"/>!;

    return $html_msg;
}