LineNumberReader myReader = new LineNumberReader( new FileReader(new File("mnt/sdcard/abc.txt")));
while(true)
{   
    while(myReader.readLine() != null) {
        counter++;
    }

    if(counter > 100 )
    {
        //CLOSE myReader
        myReader.close();
        PrintWriter writer = new PrintWriter("/mnt/sdcard/abc.txt");
        writer.print("");
        writer.close();
        writer = null;
        counter = 0;
        //REOPEN myReader
        myReader = new LineNumberReader( new FileReader(new File("mnt/sdcard/abc.txt")));
    }
}