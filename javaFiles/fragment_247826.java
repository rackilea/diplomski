Unix4j.fromStrings("1:here is no error", "2:ERRORS everywhere", "3:another ERROR", "4:nothing").toFile("blah.txt");
Unix4j.fromFile("blah.txt").grep(Grep.Options.v, "ERROR.*").sed("s/ERROR/blah/g").toFile("output.txt");     
Unix4j.fromFile("output.txt").toStdOut();       

>>>
1:here is no error
4:nothing