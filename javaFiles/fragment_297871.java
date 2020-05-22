Icon i1 = new ImageIcon(getClass().getResource("image.jpg"));
    l4 = new JLabel(i1);

    l4.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

            String command = "rundll32 url.dll,FileProtocolHandler https://www.google.com";
            try {
                Process p = Runtime.getRuntime().exec(command);

            } catch (Exception e1) {

                JOptionPane.showMessageDialog(null, "\n Error! \n");

            }

        }
    });
    add(l4);