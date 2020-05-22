public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setSize(new Dimension(400, 200));

            JPanel body = new JPanel();
            body.setLayout(new GridBagLayout());

            GridBagConstraints c1 = new GridBagConstraints();
            c1.fill = GridBagConstraints.HORIZONTAL;
            c1.weightx = 1.0;// 100%
            c1.gridx = 0;// column 0
            c1.gridy = 0;// row 0
            body.add(new JLabel("Inserimento di un nuovo protocollo"), c1);

            JTextArea oggetto = new JTextArea(5,1);
            oggetto.setOpaque(true);
            oggetto.setBackground(Color.cyan);

            GridBagConstraints c2 = new GridBagConstraints();
            c2.fill = GridBagConstraints.BOTH;
            c2.weightx = 1.0; // 100%
            c2.gridx = 0; // column 0
            c2.gridy = 1; // row 1

            body.add(oggetto, c2);
            frame.add(body);
            frame.setVisible(true);

        }