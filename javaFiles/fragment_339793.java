private String load(String textfile){
        String temp="";
        String filepath = projectPath + textfile;
        try{
            BufferedReader reader =new BufferedReader(new FileReader(filepath));
            while(true){
                //this will read one line at a time you can append it output
                try {
                    temp+= reader.readLine();
                    //If no more lines break out of the loop
                    if(line==null)
                        break;

                }catch(IOException e){}
            }
            reader.close();
        }
        catch(IOException e){}
        //Return contents of the file you loaded
        return temp;
    }