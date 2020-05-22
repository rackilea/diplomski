button.addActionListener(new ActionListener() {
        int clicks = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (++clicks) {
                case 1:
                    label.setText("hello");
                break;

                case 2:
                    label.setText("sharma");
                break;

                //continue doing it like this
            }
        }
    });