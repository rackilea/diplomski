@Override
        public void handle(ActionEvent event) {

            Thread thread = new Thread(() -> {
                int temp = 0;
                Calendar calendar = Calendar.getInstance();

                System.out.println("Seconds in current minute = " + calendar.get(Calendar.SECOND));

                temp = calendar.get(Calendar.SECOND);
                int counter = 1;

                do {
                    calendar = Calendar.getInstance() ;
                    if (temp != calendar.get(Calendar.SECOND)) {
                        System.out.println("Seconds in current minute = " + calendar.get(Calendar.SECOND));
                        double rotation = 6.0 * counter ;
                        Platform.runLater(() -> imageHolder2.rotateProperty().set(rotation) );
                        counter++;
                        temp = calendar.get(Calendar.SECOND);
                    }

                } while (counter <= 60);
            });

            thread.setDaemon(true);
            thread.start();
        }