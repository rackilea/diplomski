public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(3, 1));
                frame.add(new Label("One", Color.BLACK));
                frame.add(new Label("Two", Color.BLACK));
                frame.add(new Label("Three", Color.BLACK));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public class Label extends JPanel {

        JButton btnDeleteObject;
        // Delete icon
        ImageIcon delIcon = new ImageIcon("Delete.png");
        Image img = delIcon.getImage();
        Image newimg = img.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledDelIcon = new ImageIcon(newimg);
        Color labelColour;

        public Label(String labelName, Color labelColour) {
            this.labelColour = labelColour;

//            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            // Not sure why you want to do this, but this would
            // be a more useful layout manager in the this context
            // Personally, I would just layout the components directly onto
            // this container...
            setLayout(new BorderLayout());

            addComponents(labelName);

        }

        private void addComponents(String labelName) {

//            JPanel innerContainer = new JPanel(new GridLayout(1, 3));
            JPanel innerContainer = new JPanel(new GridBagLayout());
            JLabel name = new JLabel(labelName);

            LabelColourBox cBox = new LabelColourBox();

//            name.setMaximumSize(new Dimension(80, 40));
//            name.setPreferredSize(new Dimension(80, 40));
//            name.setSize(new Dimension(80, 40));

            name.setBorder(BorderFactory.createLineBorder(Color.blue));

            setBorder(BorderFactory.createLineBorder(Color.black));

//      name.setBorder(new EmptyBorder(5, 5, 5, 5));

            // Add action to delete button for Icon
            Action action = new AbstractAction("Button Label", scaledDelIcon) {
                // This method is called when the button is pressed
                public void actionPerformed(ActionEvent evt) {
                    System.out.println("delete");
                }
            };

            btnDeleteObject = new JButton(action);

            // Remove label, background
            btnDeleteObject.setText("");
            btnDeleteObject.setContentAreaFilled(false);

            setAlignmentX(LEFT_ALIGNMENT);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;

            innerContainer.add(cBox, gbc);
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            innerContainer.add(name, gbc);
            gbc.gridx++;
            gbc.weightx = 0;
            innerContainer.add(btnDeleteObject, gbc);

            add(innerContainer);

        }

        public class LabelColourBox extends JPanel {

            public LabelColourBox() {
                setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(40, 40);
            }

            @Override
            public Dimension getMinimumSize() {
                return getPreferredSize();
            }

            @Override
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                // DON'T DO THIS, THIS IS A VERY BAD IDEA, THIS WILL RESULT
                // IN A NEW REPAINT REQUEST BEING SENT TO THE REPAINT MANAGER
                // CAUSE THIS METHOD TO BE CALLED AND NEW REPAINT REQUEST BEING...
                // you get the idea..
                //setBorder(BorderFactory.createLineBorder(Color.green));
                //setMaximumSize(new Dimension(40, 40));
                //setPreferredSize(new Dimension(40, 40));
                //setSize(new Dimension(40, 40));

                g.setColor(Color.RED);
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(Color.GREEN);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        }
    }
}