// [...]

    panelCreating = new JPanel();
    //panelCreating.setMinimumSize(new Dimension(160, 200));
    //panelCreating.setPreferredSize(new Dimension(160, 200));
    scrollPaneCreating = new JScrollPane(panelCreating,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPaneCreating.setMinimumSize(new Dimension(160, 200));
    scrollPaneCreating.setPreferredSize(new Dimension(160, 200));

    // [...]

        @Override
        public void actionPerformed(ActionEvent e) {
            textPane1.setText(textPane1.getText() + "\na");
            //textPane1.setPreferredSize(new Dimension(150, height));
            textPane2.setText(textPane2.getText() + "\nb");
            //textPane2.setPreferredSize(new Dimension(150, height));
            //height += 30;

            // This isn't necessary either
            //panelCreating.revalidate();
            //panelCreating.repaint();
            //scrollPaneCreating.revalidate();
        }