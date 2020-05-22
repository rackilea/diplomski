jButtonAgree.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Registration reg = new Registration(); // **** HERE *****
            LayoutManager cards = reg.getCards().getLayout();
            ((CardLayout) cards).show(reg.getCards(),"step1");
        }
    });