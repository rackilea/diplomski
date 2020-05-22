ButtonOne.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            TextView TextOne = (TextView) findViewById(R.id.TestText);
                            TextOne.setText("Hi");


                            String message = "Test";
                            Thread networkThread = new Thread() {


                              String host = "127.0.0.1"; // localhost
                              int port = 15000;
                              DatagramSocket dsocket = null;

                              public void run() {
                                try {
                                // Get the Internet address of the specified host
                                InetAddress address = InetAddress.getByName(host);

                                // wrap a packet
                                DatagramPacket packet = new DatagramPacket(
                                        message.getBytes(),
                                        message.length(),
                                        address, port);

                                // Create a datagram socket, send the packet through it, close it.
                                dsocket = new DatagramSocket();
                                dsocket.send(packet);
                                dsocket.close();
                              } catch (Exception e) {
                                e.printStackTrace();
                            }//catch
                          }//run
                         };// Networkthread
                         networkThread.start();//networkThread.start()
                        }//onClick
                    }//onClickListener
            );//setOnClickListener