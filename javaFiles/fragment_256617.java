#!/usr/bin/env perl6
use v6;

say 'Start';
my $proc = Proc::Async.new('sleep', 10);

my $promise= $proc.start;
say 'Process started';
sleep 2;
$proc.kill;
await $promise;
say 'Process killed';