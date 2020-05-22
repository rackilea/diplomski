File file = null;
        //Automatically closes resources try-with-resources block
        try( FileReader fileReader = new FileReader(file);BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line;
            boolean code_started = false;
            while((line = bufferedReader.readLine()) != null){
               //Code Goes Here
            }
        }catch(FileNotFoundException fn_ex){
            throw new Exception("File not found!");
        }
        catch(IOException io_ex){
            throw new Exception("Failed to read file: " + file.getName() + "!");
        }