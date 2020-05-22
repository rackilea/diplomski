public void doit() {
    final Timer timer = new Timer(5000, null);

    ActionListener a = new ActionListener() {
        private int i = 0;

        public void actionPerformed(ActionEvent e) {
            if (i > 10) {
                timer.stop();
            } else {
                textArea1.append("   " + i + "\n");
                textArea1.setCaretPosition(textArea1.getDocument().getLength());
                i++;
            }
        }
    };
    timer.addActionListener(a);
    timer.start();
}