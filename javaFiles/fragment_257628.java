//File is on my Desktop
    Path myFile = Paths.get(System.getProperty("user.home")).resolve("Desktop").resolve("tester.txt");
    //Try-With-Resources so we autoclose the reader after try block
    try(BufferedReader reader = new BufferedReader(new FileReader(myFile.toFile()))){
        String[] headings = reader.readLine().split(",");//Reads First line and gets headings
        String line;
        while((line = reader.readLine()) != null){//While there are more lines
            String[] values = line.split(","); //Get the values
            for(int i = 0; i < values.length; i++){//For each value
                System.out.println(headings[i] + ":  " + values[i]);//Print with a heading
            }
        }
    } catch (IOException io) {
        io.printStackTrace();
    }