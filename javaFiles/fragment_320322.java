@Override
            public void on(String event, IOAcknowledge ack, Object... args) {
                // TODO Auto-generated method stub
                if(event.equals("new_client_message")){
                    Log.v("SocketIO", "new_client_message" + " " + args[0]);
                    rohan = args[0].toString();
                    System.out.println("admin" + " : " + " " + rohan);

                    runOnUiThread(new Runnable(){

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mListData.add("Admin" + " : " + " " + rohan);
                            mListData.notifyDataSetChanged();
                            lvList.setSelection(mListData.getCount() -1);

                        }

                    });
                }