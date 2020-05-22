public void actionPerformed(ActionEvent e) {
Object scr = e.getActionCommand();
if (scr.equals("Start") && (serverSocket == null || serverSocket.isClosed())) {
    // new JFrame().StartServerToggleButton.setEnabled(false);

    if(PortisInteger(frame.getPortTextField())) {
        if(ServerStart(portNumber)) {
            frame.setIPLabel("IP: " + serverSocket.getInetAddress().getHostName());
        }
    }
}