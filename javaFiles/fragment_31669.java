public void write(final int b) {
    try {
        sentence = sentence + (char) b;
        if (sentence.endsWith("\n") && !sentence.isEmpty()
                && !sentence.equals("\t") && !sentence.equals("\r\n")
                && !sentence.equals("\n")) {
            if (writing == false) {
                writing = true;
                final String text = sentence.replaceAll("\n", "")
                                .replaceAll("\r", "").trim();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        subject.addElement(text);
                    }
                });

            }
            sentence = "";
            writing = false;
        }
    } catch (Exception e) {
        e.printStackTrace(Boot.stdErr);
    }
}