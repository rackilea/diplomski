Scanner scan = new Scanner(stream);
while (scan.hasNextLine()) {
    String line = scan.nextLine();
    if(line.startsWith("\t<sessionid>"))
    {
        System.out.println(line.substring("\t<sessionid>".length()));
    }
 }