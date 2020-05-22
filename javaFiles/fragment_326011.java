StringHolder firstArg = new StringHolder("?a");
StringHolder secondArg = new StringHolder("?b");

StringHolder[] action = { new StringHolder("jump"), firstArg, secondArg }
StringHolder[] action2 = { new StringHolder("run"), secondArg, firstArg }

firstArg.setString("k");