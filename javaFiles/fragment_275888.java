new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    //YOUR CODE HERE
                        Message message = new Message();
                        message.obj = comingMsg;
                        mHandler2.sendMessage(message);
                }
            });