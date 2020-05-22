#! /usr/bin/perl
#
print "<xml>\n";
while($line = <>) {
    if ($line =~ m!-- File (.*)!) {
        print "    <header $1/>\n";
        print "    <listofrecords>\n";
        last;
    }
}
while($line = <>) {
    if($line =~ m!<xml>(.*)</xml!) {
        print "        <$1/>\n";
    }
}
print "    </listofrecords>\n";
print "</xml>";