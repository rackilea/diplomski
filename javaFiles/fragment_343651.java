BufferedReader br = new BufferedReader(new FileReader("myFile.txt"));
String line = br.readLine();
String [ ] words = line.split ( "," );
for(int i = 0; i < words.length; i++)
{
    switch(words[i])
    {
       case " up":
       case "up":
           moveUP(Integer.parse(words[i + 1]);
           i++;
           break;

       case " down":
       case "down":
           moveDown(Integer.parse(words[i + 1]);
           i++;
           break;

       case " left":
       case "left":
           moveLeft(Integer.parse(words[i + 1]);
           i++;
           break;

       case " right":
       case "right":
           moveRight(Integer.parse(words[i + 1]);
           i++;
           break;
    }
}