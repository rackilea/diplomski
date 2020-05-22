try {
  int nServer= Integer.parseInt(server.getText().toString());
    int nLength = Integer.parseInt(length.getText().toString());
    int nSpeed = Integer.parseInt(speed.getText().toString());
    int p= Integer.parseInt(probP.getText().toString());
    int r = Integer.parseInt(probR.getText().toString());
    int addAll = nServer+nLength+nSpeed+p+r;
    print(addAll);
} catch (NumberFormatException e) {
   //alert the user that the number they tried to enter was invalid
 }