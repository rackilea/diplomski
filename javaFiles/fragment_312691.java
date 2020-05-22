equalsIgnoreCase()

      {
            this.readSms("inbox");
 Log.d("entering into ","inbox");
        }
    }
    public void readSms(String folder)
    {

        if(folder.equals("inbox"))

uriSMSURI = Uri.parse("content://sms/inbox");
}