JPanel newContentPane = new JPanel();

    newContentPane.setLayout(new BorderLayout()); // *** added this

    ImageComponent card = new ImageComponent();
    card.setImage(getCodeBase() + "/cards/as.jpg");

    newContentPane.add(card, BorderLayout.CENTER);  // *** changed