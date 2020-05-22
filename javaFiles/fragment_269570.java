SpreadSheet spreadSheet = SpreadSheet.create(1,20,50);

    Sheet sheet = spreadSheet.getSheet(0);

    int lineIndex = 1;
    for (String value : valueset) {
        sheet.setValueAt(value,1, lineIndex);

        lineIndex++;
    }

    spreadSheet.saveAs(new File("/home/me/example.ods"));