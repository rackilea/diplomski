private void dragDetected(MouseEvent mouseEvent) {
    Dragboard db;
    ClipboardContent cc;


    if(mouseEvent.getSource() instanceof CardPane){
        CardPane source = (CardPane) mouseEvent.getSource();
        cc = new ClipboardContent();
        db = source.startDragAndDrop(TransferMode.MOVE);

        if(source.getCard() != null) {
            //IF from stacks or nextCards
            if (stacks.contains(source) || nextCards.contains(source)) {
                db.setDragView(source.getCard().getImage());
                cc.putString(String.valueOf(source.getCard().getNumber()));
            } else {
                //PLACE MULTIPLE IMAGES TO THE DRAGBOARD HERE
                Pane stackImagePane = new Pane();
                Optional<List<CardPane>> stackListOptional = cards.stream()
                                                    .filter(list -> list.stream()
                                                    .anyMatch(e -> e.equals(source))
                                                    )
                                                    .findFirst();

                if(stackListOptional.isPresent()){
                    ArrayList<CardPane> stackList = (ArrayList) stackListOptional.get();

                    double y = 0;
                    for (CardPane e : stackList) {
                        ImageView view = new ImageView(e.getImage());
                        view.setY(y);
                        y += 20;
                        stackImagePane.getChildren().add(view);
                    }

                    Image ghostStack = stackImagePane.snapshot(null,null);
                    db.setDragView(ghostStack);
                    cc.putString(String.valueOf(source.getCard().getNumber()));
                }

            }

            db.setContent(cc);
            source.setVisible(false);
        }
    }


}