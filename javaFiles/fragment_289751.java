while ((line = bufferedReader.readLine()) != null) {
                // SENDING EVENT LINES ...
                String Agentname="Reciever";
                ACLMessage aclMessage= new ACLMessage(ACLMessage.CONFIRM);
                aclMessage.addReceiver(new AID(Agentname,AID.ISLOCALNAME));
                aclMessage.setContent(line);
                send(aclMessage);
                // Block an Agent until a confirmation is received..
                ACLMessage aclMessage2 = blockingReceive(mt);
            }