IncomingHandler progresshandler = new IncomingHandler(YourActivity.this);
        if (editMessage.getText().toString().length() > 0) {
            SendMessagesThread thread = new SendMessagesThread(progresshandler);
            thread.start(); 
            // progressDialog.show();
        }