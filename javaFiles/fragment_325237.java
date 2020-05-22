// non-SAM with adapter implementation with override
    window.addWindowListener(
        new WindowAdapter() {
            @Override
            public void windowOpened(Event e){
                System.out.println("WindowAdapter opened via override!");
            }
        }
    );