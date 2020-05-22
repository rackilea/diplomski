for (int i = 0; i < logArray.length; i++) {
    for (int x = 0; x < checkArray.length; x++) {
            if (logArray[i].equals(checkArray[x])) {
                isFound = true; // <-Add this, because right now logsNotFound is incremented no matter what without this statement
                logsFound = logsFound + 1;
                modelFound.addElement("<html><font color=#009933>FOUND: </font> " + logArray[x] + "</html>");
            }
    }
    if (isFound == false) {
                logsNotFound = logsNotFound + 1;
                modelNotFound.addElement("<html><font color=#FF0000>NOT FOUND: </font> " + logArray[i] + "</html>");


    }
    isFound = false;
}