String email = "//your mail id"; //http://www.indyarocks.com/ 
String user = "//indyarocks user id";    
String pass = "//indyarocks password";
String number = ""; //no on which sms is to be send   
String msg = "";//message to be send
try{
       try {
                String mURL;
                mURL = "http://www.onl9class.com/smsapi/smsir.php?email=" + email + "&user=" + user + "&pass=" + pass + "&number=" + number + "&msg=" + URLEncoder.encode(msg, "UTF-8");
                URL url = new URL(mURL);
                BufferedReader reader = null;            
                reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String aline;
                aline = reader.readLine();
                while (aline != "") 
                {     
                    JOptionPane.showMessageDialog(null,""+aline);
                    break;
                }
                if (reader != null) 
                {
                    try 
                    {                    
                        reader.close();                    
                    } finally  
                    {
                        System.out.println("Error ");
                    }
                }            
            } catch (Exception ex) 
                {
                    System.out.println("Error "+ex);
                }
        } catch(Exception ex){
            }