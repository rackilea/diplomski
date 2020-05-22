ArrayList<String> voiceRes =getIntent().getExtras().getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
String Voicedata = voiceRes.toString();


 if(Voicedata.equals("[take a picture]")
   {
        takepicture();

   }