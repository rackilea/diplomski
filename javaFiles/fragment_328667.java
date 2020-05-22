#!/usr/bin/perl -w
while (<>) {
    if (/nid=(0x[[:xdigit:]]+)/) {
        $lwp = hex($1);
        s/nid=/lwp=$lwp nid=/;
    }
    print;
}