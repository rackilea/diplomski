#!/usr/bin/perl

my $cmd = "dbus-monitor --session \"type='signal',interface='org.gnome.ScreenSaver',member='ActiveChanged'\"";

open (IN, "$cmd |");

while (<IN>) {
    if (m/^\s+boolean true/) {
        print "*** Screensaver is active ***\n";
    } elsif (m/^\s+boolean false/) {
        print "*** Screensaver is no longer active ***\n";
    }
}