final JButton button = new JButton("Something");
button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(final ActionEvent ae) {
        // do something
    }
});

final Object[] options = new Object[] { button };

int result = JOptionPane.showOptionDialog(null, getPanel(),"Return Builder", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");