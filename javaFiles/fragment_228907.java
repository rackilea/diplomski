Process send1 = Runtime.getRuntime().exec(new String[] {"javac", "/tmp/"+ fileName});
send1.waitFor();  // this returns an int with the exit status of the command - you really should check this!
Process send2 = Runtime.getRuntime().exec(new String[] {"sed", "-i", "s/Foo/Foo2/g", "/tmp/"+ fileName});
send2.waitFor();
Process send3 = Runtime.getRuntime().exec(new String[] {"java", "/tmp/"+ fileNameShort+".class"});
send3.waitFor();