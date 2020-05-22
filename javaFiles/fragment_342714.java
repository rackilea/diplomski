FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.csv"), "windows-1252")); // Or try "Cp1252" in place of "windows-1252"

        String lineOfText;
        while ((lineOfText = br.readLine()) != null) {
            //do something
        }
        br.close();