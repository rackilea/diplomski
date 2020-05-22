String[] arr= null;
    List<String> itemsSchool = new ArrayList<String>();

    try 
    { 
        FileInputStream fstream_school = new FileInputStream("text1.txt"); 
        DataInputStream data_input = new DataInputStream(fstream_school); 
        BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input)); 
        String str_line; 

        while ((str_line = buffer.readLine()) != null) 
        { 
            str_line = str_line.trim(); 
            if ((str_line.length()!=0))  
            { 
                itemsSchool.add(str_line);
            } 
        }

        arr = (String[])itemsSchool.toArray(new String[itemsSchool.size()]);
    }