final ExpectJ expectJ = new ExpectJ();
final Spawn spawn = expectJ.spawn("host", 22, "user", "pass");
spawn.send("cd public_html/final\n");
spawn.expect("someReturn");
...
spawn.send("exit\n");
spawn.expectClose();