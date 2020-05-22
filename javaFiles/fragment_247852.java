private javax.swing.JPanel containerPanel;
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Shop Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        containerPanel = new javax.swing.JPanel();
        containerPanel.add(jLabel1);
        add(containerPanel, gridBagConstraints);
    }

    //Variable declarationg
    private javax.swing.JLabel jLabel1;


    //Setter for Shop Name
    public void setArmorImage(JLabel shopLabel) {
        containerPanel.remove(jLabel1);
        containerPanel.add(shopLabel);
        jLabel1 = shopLabel;
        revalidate();
    }