spinner.addFocusListener(new FocusListener() {

    public void focusGained(FocusEvent e) {

        // editor is ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
        // necessary to set focus on the text component of jspinner
        editor.requestFocus();

        // this if you want to select the displayed text of jspinner
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("run");
                editor.selectAll();
            }
        });
    }

    public void focusLost(FocusEvent e) {}
});