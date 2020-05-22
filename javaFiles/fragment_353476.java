ObservableSocket observableSocket = new ObservableSocket("localhost", 3339);
    observableSocket.addListener(new ObservableSocketListener() {

        @Override
        public void dataAvailable(ObservableSocketEvent event) {
            System.out.println("data received: "+new String(event.getData()));
        }

        @Override
        public void closed(ObservableSocketEvent event) {
            System.out.println("closing socket");
        }

        @Override
        public void errorOccured(ObservableSocketEvent event) {
            System.out.println("error occured");
            event.getException().printStackTrace();
        }


    });
    Thread.currentThread().sleep(10000);
    observableSocket.die();