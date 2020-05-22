public void actionPerformed(ActionEvent e) {
    if ("aroundthelake".equals(e.getActionCommand())) {
        new Thread() {
            public void run() {
                try { 
                    System.out.println("initiated");
                    URL website = new URL("http://theneverhood.sourceforge.net/setup.exe"); 
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                    FileOutputStream fos = new FileOutputStream("setup.exe");
                    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
                } catch (IOException exc) { 
                    System.out.println(exc);
                }   
            }   
        }.start();

    } else {
        // man
    }   
}