for (String read = readFromFile.readLine(); read != null; read = readFromFile.readLine()) {
            System.out.println(read+"a");
            if(!read.equals(""))//to check whether the line is empty
            {
            String[] readSplit = read.split("\\s+");
            int age = Integer.parseInt(readSplit[2]);
            System.out.println(readSplit[0] + " is " + age + " years old.");    
            }
        }