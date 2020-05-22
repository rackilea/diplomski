ArrayList<String> dinosaur = new ArrayList<String>(); // <String> is an explicit type declaration


    // This will reference one line at a time
    String line = null;
    int i=0;
    try 
    {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader("file.txt");

      //create buffered reader obj 
      BufferedReader bufferedReader = new BufferedReader(fileReader);

//while not EOF, store line in array element
      while ( (line = bufferedReader.readLine ()) != null) {

        dinosaur.add(line);

        i++;
      }


      // Always close files.
      bufferedReader.close();
    }
    //handle exceptions
    catch(FileNotFoundException e) 
    {
      System.out.println("Unable to open file" + e);
    }
    catch(IOException e) 
    {
      System.out.println("Error reading file" + e);
    }