public static void receiveEmail(String pop3Host, String storeType,final String user, final String password) {  
              try {  
               //1) get the session object  
               Properties props = new Properties();  
               props.put("mail.pop3.host", "pop.gmail.com");

               props.put("mail.pop3.ssl.enable", "true"); // Use SSL

               props.put("mail.pop3.user", user);

               props.put("mail.pop3.socketFactory", 995);

               props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

               props.put("mail.pop3.port", 995);

               Session session = Session.getDefaultInstance(props, new Authenticator() {
                   @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);

                    }
                });  

               //2) create the POP3 store object and connect with the pop server  
               Store emailStore = (Store) session.getStore(storeType);  
               emailStore.connect("pop.gmail.com",995,user, password);  

               //3) create the folder object and open it  
               Folder emailFolder = emailStore.getFolder("INBOX");  
               emailFolder.open(Folder.READ_ONLY);  

               //4) retrieve the messages from the folder in an array and print it  
               Message[] messages = emailFolder.getMessages();  
               for (int i = 0; i < messages.length; i++) {  
                Message message = messages[i];  
                System.out.println("---------------------------------");  
                System.out.println("Email Number " + (i + 1));  
                System.out.println("Subject: " + message.getSubject());  
                System.out.println("From: " + message.getFrom()[0]);  
                System.out.println("Text: " + message.getContent().toString());  
               }  

               //5) close the store and folder objects  
               emailFolder.close(false);  
               emailStore.close();  

              } catch (MessagingException e) {e.printStackTrace();}  
              catch (IOException e) {e.printStackTrace();}  
             }