BufferedReader reader = new BufferedReader(new FileReader("D:/Names.txt"));
    String line = null;

    while ((line = reader.readLine()) != null)
    {
        System.out.println(line);
        String[] lastName = line.split("\\s");

        String firtLetterOfFirstName = lastName[0].substring(0, 1);
        System.out.println("Folder Name : "+firtLetterOfFirstName + lastName[1]);
        File file = new File("D:\\"+firtLetterOfFirstName + lastName[1]);
        if(false== file.exists())
        {
            file.mkdir();
        }

    }