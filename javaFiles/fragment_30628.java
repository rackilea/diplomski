public void onUploadFile(ActionEvent actionEvent) {

    if (file != null && inputstream != null) {
        fileName = file.getFilename();
        System.out.println("Notepad Name: " + fileName);

        final Scanner scanner = new Scanner(inputstream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //do somthing with the current line, like store each one in a list
            System.out.println(line);
            String[] lineElements=line.split(" ");
            //16/05/2014 17:19:00 6685 00:00:31
            //in your case lineElements[0] should be a date 
            //lineElements[1] is a timestamp linked to the before date 
            //lineElements[2] is a number (int)
            //lineElements[3] is a timestamp
            //build string from elements [0] and [1] then transform it to a date
            //add logic for adding to database...
        }
    }

    if (inputFile != null) {

        inputFile.resetValue();
        inputFile.setValid(true);

    }
}