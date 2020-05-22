//This gets your project directory
    private String projectPath = System.getProperty("user.dir");
    //call save()
    String save("test.txt", "This is will be save to a test.txt file");

    private boolean save(String textfile String outputtext){
        String filepath = projectPath + textfile;

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(outputtext);
            writer.close();
        } catch(IOException e) { }

        return true;
    }