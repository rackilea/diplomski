public static void replaceSelected(String replaceWith, String type) {
    try {
        // input the file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader("notes.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();
        String inputStr = inputBuffer.toString();

        System.out.println(inputStr); // display the original file for debugging

        // logic to replace lines in the string (could use regex here to be generic)
        if (type.equals("0")) {
            inputStr = inputStr.replace(replaceWith + "1", replaceWith + "0"); 
        } else if (type.equals("1")) {
            inputStr = inputStr.replace(replaceWith + "0", replaceWith + "1");
        }

        // display the new file for debugging
        System.out.println("----------------------------------\n" + inputStr);

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream("notes.txt");
        fileOut.write(inputStr.getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }
}