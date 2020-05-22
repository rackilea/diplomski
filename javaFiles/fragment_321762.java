BroadCastThread bct = new BroadCastThread();
        bct.start();

        //With lambda
        bct.addTask(() -> {
            //Send file code
        });

        //Without lambda
        bct.addTask(new SendFileTask() {
            @Override
            void sendFile() throws Exception {
            //Send file code
            }
        });