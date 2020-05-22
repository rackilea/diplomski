if ( answer.equals("help") ) {
    for (int i = 0; i < enterCommand.length; i++){
        try {
            Thread.sleep(1000);
            System.out.println(help[i]);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

} // end of for
} // end of if