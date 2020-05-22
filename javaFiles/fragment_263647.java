Window.addWindowClosingHandler(new Window.ClosingHandler() {
        @Override
        public void onWindowClosing(ClosingEvent event) {
            event.setMessage("If you leave this page, your IM sessions will not be preserved!");
        }
    });

    Window.addCloseHandler(new CloseHandler<Window>() {
        @Override
        public void onClose(CloseEvent<Window> event) {
            // My async code to be executed
        }
    });