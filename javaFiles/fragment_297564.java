Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Your msg here" + msg.getText(), Toast.LENGTH_LONG);
                    }
                });