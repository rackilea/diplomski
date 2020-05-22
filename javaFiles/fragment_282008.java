for (int i = 0; i < checkArray.length; i++) {
        for (int x = 0; x < logArray.length; x++) {
        isFound = false;
            if (logArray[x].equals(checkArray[i])) {
                isFound = true;
                logsFound = logsFound + 1;
                modelFound.addElement("<html><font color=#009933>FOUND: </font> " + checkArray[i] + "</html>");
            }
        }
        if (isFound == false) {
            logsNotFound = logsNotFound + 1;
            modelNotFound.addElement("<html><font color=#FF0000>NOT FOUND: </font> " + checkArray[i] + "</html>");
        }         
    }