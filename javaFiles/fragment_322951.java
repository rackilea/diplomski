private void performOperationInBackgroundThread() {
        Thread Servicethread = new Thread(
                    new Runnable() {
                        public void run() {
                            try {
                                PerformThreadOperation();
                                DataLoaded = true;
                            } catch (Exception e) {
                                ExceptionOccured = true;
                                e.printStackTrace();
                                System.out.println(e.getMessage());
                            }
                            handler.sendMessage(handler.obtainMessage());
                        }
                    }
                    );
            Servicethread.start();
        }


 static class MyHandler extends Handler{
                MyActiviy parentActivity;
                @Override
                public void handleMessage(Message msg){
                    // Update your UI here

                    }
                }

                MyHandler(MyActiviy activity){
                    parentActivity = activity;
                }
            }

MyHandler handler = new MyHandler(this);