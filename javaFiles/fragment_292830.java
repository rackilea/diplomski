String eol = System.getProperty("line.separator");

... somewhere else in your code ...

String texttosave = "Here is a line of text." + eol;

... more code.. optionally adding lines of text .....
// call your save file method
saveFile(texttosave);