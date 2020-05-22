private String readFile(){
      // The name of the file to open.
        String fileName = "PATH/TO/THE/FILE/THAT/IS/GOING/TO/BE/UPLOADED/FILE_NAME/xml";

        // This will reference one line at a time
        String line = null;
        // This will be the full file after reading
        String output = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                output = output + line;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                output = output + "Unable to open file '" + fileName + "'";         
        }
        catch(IOException ex) {
            System.out.println( 
                output = output + "Error reading file '" + fileName + "'";         
        }

      return output;
  }