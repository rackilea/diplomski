public void closeEXES() {
    int n = JOptionPane.showConfirmDialog(mainframe,
            "Close EXES GUI?", "Closing EXES GUI",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    if (n == 0) {
        System.out.println("Exiting...start");
        doCloses();
        System.exit(0);
    }
}

public void doCloses() {
    if ( beenClosed )
    {
        System.out.println("Already closed all files.");
    }
    else
    {
        // ... a bunch of stuff here writing GUI screen positions to a file and
        // things like that ...

        beenClosed = true;
    }
}