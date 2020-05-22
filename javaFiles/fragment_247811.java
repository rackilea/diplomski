bConnect.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                        InetAddress address = InetAddress.getByName(host); // host IPaddress
                        socket = new Socket(address, port); // port same as server
                        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                        final Timer time = new Timer(); // to get new server txt if it changes
                        TimerTask t = new TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                    String kry = br.readLine(); 
                                // use message from server
                                } catch (Exception e1) {
                                    JOptionPane.showMessageDialog(null, "The Server has just gone offline");
                                }
                            }
                        };
                        time.scheduleAtFixedRate(t, 0, 2000);
                }
                catch (Exception e1)
                {e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "The Server is not online");}
        }
    });



bSend.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textGekry = "what you are sending";
            if (!textGekry.equals(""))
            {
                String sendMessage = textGekry + "\n";
                try
                {
                    bw.write(sendMessage);
                    bw.flush();
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"The Server is most likely offline");
                }
            }
        }
    });