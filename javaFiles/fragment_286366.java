try {
        Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
        for (Object msg : messages) {
            byte[] bytes = (byte[]) msg;
            SmsMessage message = SmsMessage.createFromPdu(bytes);
            String messageBody = message.getDisplayMessageBody(); // this is your SMS message body
        } catch (Exception e) {
            //catch exception here
        }