public EventHandler<Event> createSolButtonHandler()
{
    btnSolHandler = new EventHandler<Event>() {

        @Override
        public void handle(Event event) {
            System.out.println("Pressed!");
            biddingHelperFrame.getBtnSag().setVisible(false);
        }
    };
    return btnSolHandler;
}