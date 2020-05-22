String[] command = new String[] {
                       "java",
                       "-jar",
                       "g:\\My Documents\\Dropbox\\Final Project\\Code\\Mano CPU\\Inputs\\Parser\\java-cup-11a.jar",
                       "-destdir",
                       "g:\\My Documents\\Dropbox\\Final Project\\Code\\Mano CPU\\src\\Assembler",
                       "G:\\My Documents\\Dropbox\\Final Project\\Code\\Mano CPU\\Inputs\\Assembler\\Assembler.cup",
                   };

Process p = Runtime.getRuntime().exec(command);