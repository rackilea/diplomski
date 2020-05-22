String line = "";
    while (scanner.hasNext()) {
        String lineOfText = scanner.nextLine();
        if (lineOfText.startsWith("001")) {
            lineOfText = lineOfText.substring(3);
            System.out.println(lineOfText);
            line += lineOfText + "<br>";
        }
    }
    if (line.length() > 0) {
        line = "<html>" + line.substring(0, line.length() - 4) + "</html>";
    }
    Letters001.setText(line);