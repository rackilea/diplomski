public HotelDescriptor readLine(final String line) {
    // Split on various possible combinations of how the
    // delimiter might be formated within a file line.
    String info[] = line.split(" ; |; |;"); 
    // Variables declaration and default initialization values
    String tempname = "";
    String tempaddress = "";
    float templatitudeh = 0.0f;
    float templongitudeh = 0.0f;
    int singleroom = 0;
    int singleprice = 0;
    int doubleroom = 0;
    int doubleprice = 0;
    int suiteroom = 0;
    int suiteprice = 0;

    String strg; // Used to hold the current Array Element in the for/loop
    String regExF = "-?\\d+(\\.\\d+)?"; // RegEx to validate a string float or double value.
    String regExI = "\\d+";             // RegEx to validate a string Integer value.
    for (int i = 0; i < info.length; i++) {
        strg = info[i].trim(); // remove leading/trailing spaces if any
        switch (i) {
            case 0:
                tempname = info[i];
                break;
            case 1:
                tempaddress = info[i];
                break;
            case 2:
                // Is it a float or double numerical value
                if (strg.matches(regExF)) {
                    templatitudeh = Float.parseFloat(info[i]);
                }
                break;
            case 3:
                // Is it a float or double numerical value
                if (strg.matches(regExF)) {
                    templongitudeh = Float.parseFloat(info[i]);
                }
                break;
            case 4:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    singleroom = Integer.parseInt(info[i]);
                }
                break;
            case 5:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    singleprice = Integer.parseInt(info[i]);
                }
                break;
            case 6:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    doubleroom = Integer.parseInt(info[i]);
                }
                break;
            case 7:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    doubleprice = Integer.parseInt(info[i]);
                }
                break;
            case 8:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    suiteroom = Integer.parseInt(info[i]);
                }
                break;
            case 9:
                // Is it a Integer numerical value
                if (strg.matches(regExI)) {
                    suiteprice = Integer.parseInt(info[i]);
                }
                break;
        }
    }

    Hotel tempHotel = new Hotel(tempname, tempaddress, templatitudeh, templongitudeh, 
            singleroom, singleprice, doubleroom, doubleprice, suiteroom, suiteprice);
    System.out.println(tempHotel.getName());
    return tempHotel;
}

public List<HotelDescriptor> readFile(final String hotels) {
    try (BufferedReader buff = new BufferedReader(new FileReader(hotels))) {
        String line;
        int lineCounter = 0;
        while ((line = buff.readLine()) != null) {
            // Trim any leading or trailing spaces (spaces, tabs, etc)
            line = line.trim();
            lineCounter++; 
            // Is this the right file to read?
            if (lineCounter == 1) {
                if (!line.equalsIgnoreCase("My App Name - Hotels Data File")) {
                    //No it isn't...
                    JOptionPane.showMessageDialog(this, "Invalid Hotels Data File!",
                            "Invalid Data File", JOptionPane.WARNING_MESSAGE);
                    break; // Get out of while loop
                }
                // Otherwise skip the File Descriptor line.
                else { continue; }
            }
            // Is this a blank or Comment line...
            // Lines that start with ; are comment lines
            if (line.equals("") || line.startsWith(";")) {
                // Yes it is...skip this line.
                continue;
            }
            // Process the data line...
            hotelData.add(readLine(line));
        }
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    return hotelData;
}