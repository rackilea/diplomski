String msg = "Bruce Wayne,Batman,None,Gotham City,Robin,The Joker\n" +
         "Oliver Queen,Green Arrow,None,Star City,Speedy,Deathstroke\n" +
         "Clark Kent,Superman,Flight,Metropolis,None,Lex Luthor\n" + 
         "Bart Allen,The Flash,Speed,Central City,Kid Flash,Professor Zoom";

String[] lines = msg.split("\n");
for(Integer i = 1; i <= lines.length; i++){
    int numChars = 0;
    String[] toks = lines[i - 1].split(",");
    for(String tok : toks){
        numChars += tok.replaceAll(" ", "").length();
    }
    System.out.println("Line " + i.toString() + " beginning with " + 
            toks[0] + " and ending with " + toks[toks.length - 1] + 
            " contains " + Integer.toHexString(numChars) + 
            " characters." );
}