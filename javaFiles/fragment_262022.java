private void startListeningForWork(){
        workListener = new Thread(() -> {
            while(!master.isClosed()){
                try {
                    receiveTask();
                } catch (NotConnectedToMasterException ex) {
                    break;
                }
            }
        });
        workListener.setName("WorkListener");
        workListener.start();
    }