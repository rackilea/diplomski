# command with arguments
my $proc = Proc::Async.new('echo', 'foo', 'bar');

# subscribe to new output from out and err handles:
$proc.stdout.tap(-> $v { print "Output: $v" });
$proc.stderr.tap(-> $v { print "Error:  $v" });

say "Starting...";
my $promise = $proc.start;

# wait for the external program to terminate
await $promise;
say "Done.";