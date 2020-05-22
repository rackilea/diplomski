btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         String delay = delayedttxt.getText().toString();
         int intdelay = 0;
         try{
             intdelay = Integer.parseInt(delay);
         } catch(NumberFormatException ex){
           e.printStackTrace();// Never swallow exception
         }
         flashLight.switchFlash();
         Toast.makeText("Initial Delay : " + intdelay , Toast.LENGTH_LONG).show();
    }
});