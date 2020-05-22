public Download() {
    while (!frame.isWindowClosed()) {
        try {
            // doSomething
        } catch (Exception e) {
            e.printStackTrace();
            textArea.append("****** "+e.getClass().getName()+" ******\n");
        }
    }
}