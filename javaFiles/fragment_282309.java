/**
 * Updates the supplied Room Number data within a data text file. Even the
 * Room Number can be modified.
 * 
 * @param filePath (String) The full path and file name of the Data File.
 * 
 * @param roomNumber (Integer - int) The room number to modify data for.
 * 
 * @param fieldToModify (Integer - int) The field number in the data line to 
 * apply a new value to. The value supplied here is to be considered 0 based 
 * meaning that 0 actually means column 1 (room number) within the file data 
 * line. A value of 7 would be considered column 8 (the deleted flag).
 * 
 * @param newFieldValue (String) Since the file is string based any new field 
 * value should be supplied as String. So to apply a boolean true you will need 
 * to supply "true" (in quotation marks) and to supply a new room number that 
 * room number must be supplied a String (ie: "666").
 * 
 * @return (Boolean) True if successful and false if not.
 */
public boolean updateRoomDataInFile(String filePath, int roomNumber,
        int fieldToModify, String newFieldValue) {
    // Try with resources so as to auto close the BufferedReader.
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        // Add the data file contents to a List interface...
        List<String> dataList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            dataList.add(line);
        }

        for (int i = 0; i < dataList.size(); i++) {
            line = dataList.get(i).trim();  // Trim off any leading or trailing whitespaces (if any).
            // Skip Blank lines (if any) and skip Comment lines (if any).
            // In this example file comment lines start with a semicolon.
            if (line.equals("") || line.startsWith(";")) {
                continue;
            }
            //Split each read line so as to collect the desired room number
            // since everything will always be based from this unique ID number.
            // Split is done baesed on the Pipe (|) character since this is
            // what is implied with your data example.
            String[] roomData = line.split("\\|");
            // Get the current file data line room number.
            // Make sure the first piece of data is indeed a valid integer room 
            // number. We use the String.matches() method for this along with a 
            // regular expression.
            if (!roomData[0].trim().matches("\\d+")) {
                // If not then inform User and move on.
                JOptionPane.showMessageDialog(null, "Invalid room number detected on file line: "
                        + (i + 1), "Invalid Room Number", JOptionPane.WARNING_MESSAGE);
                continue;
            }
            // Convert the current data line room number to Integer 
            int roomNum = Integer.parseInt(roomData[0]);
            // Does the current data line room number equal the supplied 
            // room number?
            if (roomNum != roomNumber) {
                // If not then move on...
                continue;
            }

            // If we reach this point then we know that we are currently on 
            // the the data line we need and want to make changes to.
            String strg = "";  // Use for building a modified data line.
            // Iterate through the current data line fields
            for (int j = 0; j < roomData.length; j++) {
                // If we reach the supplied field number to modify
                // then we apply that modification to the field.
                if (j == fieldToModify) {
                    roomData[j] = newFieldValue;
                }
                // Build the new data line. We use a Ternary Operator, it is
                // basicaly the same as using a IF/ELSE.
                strg += strg.equals("") ? roomData[j] : "|" + roomData[j];
            }
            // Replace the current List element with the modified data.
            dataList.set(i, strg);
        }

        // Rewrite the Data File.
        // Try with resources so as to auto close the FileWriter.
        try (FileWriter writer = new FileWriter(filePath)) {
            // Iterate through the List and write it to the data file.
            // This ultimately overwrites the data file.
            for (int i = 0; i < dataList.size(); i++) {
                writer.write(dataList.get(i) + System.lineSeparator());
            }
        }
        // Since no exceptions have been caught at this point return true 
        // for success.
        return true;
    }
    catch (FileNotFoundException ex) {
        Logger.getLogger("updateFileRoomStatus()").log(Level.SEVERE, null, ex);
    }
    catch (IOException ex) {
        Logger.getLogger("updateFileRoomStatus()").log(Level.SEVERE, null, ex);
    }
    // We must of hit an exception if we got
    // here so return false for failure.
    return false;
}