/**
     * this method simplest way to send SMS with no threading
     *
     * @param userSms
     * @param toNumber e.g +12246193820
     * @param body
     */
    public static void sendSMS(UserSms userSms, String toNumber, String body) {
        TwilioRestClient client = new TwilioRestClient(userSms.getAccountSid(), userSms.getAuthToken());

        //to solve if arabic numbers was submitted and avoid exceptiono
        // com.twilio.sdk.TwilioRestException: The 'To' number +???????????? is not a valid phone number.
        long phoneNumber = Long.parseLong(toNumber.replace("+", ""));// remove plus just in case cause strange parse is working ! with +s
        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", body));
        params.add(new BasicNameValuePair("To", toNumber));// in TRIAL VERSION works only with verified number with trial account
        params.add(new BasicNameValuePair("From", userSms.getFromNumber()));// for test use the one created from twilio

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message;
        try {
            message = messageFactory.create(params);
            // Get an object from its sid. If you do not have a sid,
            // check out the list resource examples on this page
            message = client.getAccount().getMessage(message.getSid());
            //store to log
            SmsService.saveSmsLog(message, userSms, body);

        } catch (TwilioRestException ex) {
            Logger.getLogger(SmslUtil.class.getName()).log(Level.SEVERE, "send sms exception", ex);
        }

    }