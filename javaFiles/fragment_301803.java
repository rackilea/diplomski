button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        EventQueue.invokeLater(new Runnable() {

          @Override
          public void run() {
                ....here... timer seems ... less... risky....
            }
        });

    }
});