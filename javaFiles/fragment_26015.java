$ cat ~/bin/fixxmlns
#!/usr/bin/perl

for (@ARGV) {

    open (FH,"<$_");
    open (NFH,">$_.x");

    $look = 1;
    while ($r = <FH>) {
        if ($look && $r =~ /earth.google.com/) {
            $r = qq{<kml xmlns="http://www.opengis.net/kml/2.2" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:gx="http://www.google.com/kml/ext/2.2">\n};
            $look = 0;
            }
        print NFH $r;
    }
    close (NFH);
    close (FH);
    rename("$_", "$_.orig");
    rename("$_.x", "$_");
}
$ fixxmlns *.kml
$ find parentdir -name "*.kml" -print0 | xargs -0 fixxmlns