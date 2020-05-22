if(e.getSource() == btnOpen) {
    try {
        if(thread2Status) { // not necessary to explicit compare booleans
            Choose();
        } else {
            stop();
        }
        thread2Status = !thread2Status;  // this line switches boolean


    } catch (IOException e1) {
        e1.printStackTrace();
    }

}