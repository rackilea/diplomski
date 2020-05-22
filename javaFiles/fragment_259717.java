// smb shared directory
new File("\\\\hostname\\c$\\workspace\\foobar1.txt").createNewFile();
// or with a mapped network drive
new File("Z:\\workspace\\foobar2.txt").createNewFile();
// or with URIs
new File(new URI("file:////hostname/c$/workspace/foobar3.txt")).createNewFile();
new File(new URI("file:///Z:/workspace/foobar4.txt")).createNewFile();