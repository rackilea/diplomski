public final static int sendGCM(final String title, final List<String> registrationID)  throws IOException{         
        int status = 0;
        MulticastResult  result =null;


        for (int start = 0; start < registrationID.size(); start += 1000) {
            int end = Math.min(start + 1000, registrationID.size());
            List<String> sublist = registrationID.subList(start, end);
            System.out.println(sublist);
            Sender sender = new Sender(apiKey);

            Message message = new Message.Builder()
                // .collapseKey("1")
                .timeToLive(86400)//sets the time of 1 day for GCM to push notifications when android device is off, offline or unavailable
                .delayWhileIdle(true)
                .addData("message", title)              
                .build();                        

            result = sender.send(message, sublist, 1);
            System.out.println("Result "+result);
        }
         if(result == null){
                throw new IOException("Could not send message");                    
            }else{
                status = 1;
            }
            return status;  
        }