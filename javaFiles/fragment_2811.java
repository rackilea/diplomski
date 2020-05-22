TimerTask return_peer_vid = new TimerTask(){
            @Override
            public void run() {

                retMessageVidStr = "test";

                ret_msg_vid_length = retMessageVidStr.length();
                byte[] msg = retMessageVidStr.getBytes();

                p_peer_vid = new DatagramPacket(msg,ret_msg_vid_length,return_peer_addr,return_peer_port);

                //check we know where to send it
                if (return_peer_addr != null && return_peer_port != 0) {
                    try {
                        s_vid.send(p_peer_vid);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        Timer return_peer_timer_vid = new Timer();
        return_peer_timer_vid.scheduleAtFixedRate(return_peer_vid,500,500);//time in milliseconds