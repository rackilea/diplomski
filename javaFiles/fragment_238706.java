@Test
public void oilGasTestng() throws InterruptedException {
    driver.get("http://www.depreportingservices.state.pa.us/ReportServer/Pages/ReportViewer.aspx?%2fOil_Gas%2fOil_Gas_Well_Historical_Production_Report");
    WebElement mSelectElement = driver
            .findElement(By
                    .xpath("//select[@id='ReportViewerControl_ctl04_ctl03_ddValue']"));
    List<WebElement> optionsList = mSelectElement.findElements(By
            .tagName("option"));

    for (int i = 2; i < optionsList.size(); i++) {
        WebElement element = optionsList.get(i);
        String newMonth = element.getText();
        /*
         * First we have read the data from file, if the file is empty then
         * download the file and save the downloaded month(which is old
         * month when v done with the downloading).
         */
        String oldMonth = "";
        if (i > 2) {
            oldMonth = getTheOldMonthFromFile();
        }
        System.out.println("Old Month= " + oldMonth + " NewMonth= "
                + newMonth);
        if (newMonth.equals(oldMonth)) {
            // IF the string are same, nthng we need to do
        } else if (!newMonth.equals(oldMonth)) {
            /*
             * If the string are not same,then i.e., considered as new
             * Month, download the new month details
             */
            element.click();
            driver.findElement(
                    By.xpath(".//*[@id='ReportViewerControl_ctl04_ctl00']"))
                    .click();
            System.out.println(newMonth
                    + " month data downloaded in csv format");
            saveIntoAFile(newMonth);
            /*
             * You can which is oldMonth which is new month, by unCommenting
             * below condition
             */
            // if (i == 4)
            break;
        }
    }
}


//Save data into a file
 private void saveIntoAFile(String oldMonth) {
    BufferedWriter bw = null;
    if (oldMonth != null) {
        file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            bw = new BufferedWriter(writer);
            bw.write(oldMonth);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//Get the oldMonth string from the file
private String getTheOldMonthFromFile() {
    if (file == null && !file.exists()) {
        return null;
    }
    String oldMonth = "";
    StringBuffer strBuffer = new StringBuffer();
    BufferedReader br = null;
    java.io.FileReader reader = null;
    try {
        reader = new java.io.FileReader(file);
        br = new BufferedReader(reader);
        while ((oldMonth = br.readLine()) != null) {
            strBuffer.append(oldMonth);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null) {
                br.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return strBuffer.toString();
}