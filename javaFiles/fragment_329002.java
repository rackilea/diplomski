public void run()
        {
          try{

               boolean access_granted=false;
               while(!stop)
               {

                 char chr=(char)in.read();


                 if(chr!='%')  // read and append char by char from the InputStreamReader "in" until it encounters a '%'
                 str+=Character.toString(chr);

                 else terminate=true;

                 if(terminate)

                 {


                  if(entry)
                  {
                    int a=str.indexOf('&');
                    int b=str.indexOf('#');
                    String username=str.substring(0,a);
                    String password=str.substring((a+1),b);
                    String ip=str.substring((b+1),str.length());
                    System.out.println("IP ADDRESS: \""+ ip+"\"");
                    String usernameA[]=convertToArray(username);
                    String passwordA[]=convertToArray(password);
                    String user=decrypt(usernameA,portt);
                    String pass=decrypt(passwordA,portt);


                    boolean accessGranted=false;
                    int response=dbManager.verify_clientLogin(user,pass);

                if(response==RegisterInfo.ACCESS_GRANTED) { 
                System.out.println("access granted"); 
                 accessGranted=true;
                }
                   int retInt=-1;
                   if(accessGranted) retInt=1;

                   out.write(retInt);

                   entry=false;
                   terminate=false;


                  }
                  else
                  {
                     terminate=false;



                     try {
                  // str includes the original single base64String produced by the swift client app which is converted back to a byte array                              

  imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(str); 
}catch(ArrayIndexOutOfBoundsException l){ exception=true; }
str="";
                      if(!exception)
                       {


         //this byte array image data is converted to a image and played on the videoPlayer, and serial images played would be visible as a video stream
                         vidPlayer.playImage(imageBytes);

                          ioexcep=false;


                        }


                        else exception=false;



                   }
             }






         }





         }catch(Exception l){ l.printStackTrace(); }















        }