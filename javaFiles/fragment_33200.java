#!/usr/bin/perl

use strict;
use warnings;
use CGI;
use DBI;

my $q = CGI->new;
print $q->header, $q->start_html('hello'), '<table>';

my $dbh = DBI->connect("dbi:SQLite:dbname=mydatabase.db", "", "", {});

my $query = <main::DATA>;
my $query_handle = $dbh->prepare($query);
$query_handle->execute();
$query_handle->bind_columns(\my($id, $name, $license));

while($query_handle->fetch()) {
  print "<tr><td>$id</td><td>$name</td><td>$license</td></tr>\n"
}

$query_handle->finish;
$dbh->disconnect;

print '</table>', $q->end_html;

__DATA__
SELECT USR.cymer_id, USR.name, ST.license
FROM users USR, status ST, upd_ate UD
WHERE
  UD.upt_id = (select max(p2.upt_id) from upd_ate p2)
  AND ST.cymer_id = USR.cymer_id
  AND ST.upt_id = UD.upt_id
ORDER BY USR.name