new Thread(
            new Runnable() {

                @Override
                public void run() {
                    Result resultws = Webservice.webservice(someInfo1, someInfo2);
                }
            }
    ).start();