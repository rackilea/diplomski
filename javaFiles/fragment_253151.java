Platform.runLater(new Runnable() {
            public void run() {
                try {
                    WindowLogin login = new WindowLogin();
                    login.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });