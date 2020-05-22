public void jButton1_ActionPerformed(ActionEvent evt) {
   try {
    sekunden = Integer.parseInt(jNumberField3.getText()); 
    minuten = Integer.parseInt(jNumberField2.getText());
    stunden = Integer.parseInt(jNumberField1.getText());
    zeit = sekunden + minuten*60 + stunden*60*60;//berechnet die zeit in sekunden
    TimeUnit.SECONDS.sleep(zeit);//here is the error
    System.out.println("zeit");
    }catch (InterruptedException e){
      //handle the exception
   }
}