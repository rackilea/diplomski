try {
        FileInputStream fis = new FileInputStream("F:\\Test.txt");
        reader = new BufferedReader(new InputStreamReader(fis));          
        String line = reader.readLine();
        while(line != null){

            //process your line here, it's just a String...   

            line = reader.readLine();
        }           

    } catch (FileNotFoundException ex) {
        ...
    } catch (IOException ex) {