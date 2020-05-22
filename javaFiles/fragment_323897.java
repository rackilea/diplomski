ExpectJ expectinator = new ExpectJ(5);
Spawn shell = expectinator.spawn("cmd /c cd C:\\Users\\naman\\Desktop & java CalculateSum");

// Talk to it
shell.expect("Enter 1 st value");
shell.send("10\n");
shell.expect("Enter second value");
shell.send("30\n");