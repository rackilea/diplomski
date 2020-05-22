// In the Monitor class
void update(Observable terminal, Object message) {
    SwingUtilities.invokeLater(new Runnable() {
        gui.methodToDisplayTheReceivedMessage((String)message); // This cast is safe, since we only ever call notifyObservers() with a string argument.
    }
}