public Example(){
    System.out.println("Example started");
    setBounds(100,100,200,200);

    System.out.println("cmGUI instantiated");
    CheckingMessagesGUI cmGUI = new CheckingMessagesGUI();
    System.out.println("Set cmGUI visible");
    cmGUI.setVisible(true);
    cmGUI.validate();

    Thread thread = new Thread(new Runnable() {
        try {
            System.out.println("timer started");
            Thread.sleep(5000);
            System.out.println("timer done");
        } catch(InterruptedException e) {
        }
        System.exit(0);
    });
    thread.start();
}