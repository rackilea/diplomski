Window.addWindowClosingHandler(new Window.ClosingHandler() {
        @Override
        public void onWindowClosing(ClosingEvent event) {
            event.setMessage("Do you wanna close?");
            System.out.println("Closing...");
        }
    });

    Window.addCloseHandler(new CloseHandler<Window>() {
        @Override
        public void onClose(CloseEvent<Window> event) {
            System.out.println("Closed!");
        }       
    });