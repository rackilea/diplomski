import android.util.Log;
    public class Mail {
        String senderId,password,receiverId,subject,body;

        public Mail() {
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void sendMail(){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        MailSender sender = new MailSender(
                                senderId,
                                password);
                        sender.sendMail(subject,
                                body,
                                senderId,
                                receiverId);
                    } catch (Exception e) {
                        Log.e("mailError",e.getMessage());
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }