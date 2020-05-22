private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)                                         
    {                                             
        new Thread(){
            public void run(){                                                   
                btnSendEmailsNow.setEnabled(false);
                //Load property files
                loadProps();
                //Read config file.
                readConfig();
                //Take filename "FromEmail_list" after reading config file. 
                BufferedReader br1=null;
                BufferedReader br2=null;
                String line1="",line2="";
                String csvSplitBy=",";
                String strMailFrom="",strPassword="";
                String strSendTo="";
                int countCSVFrom=0,countCSVSendTo;
                int EmailCount = 0;
                ProgressMonitor pm = new ProgressMonitor(null, "Loading Progress", "Getting Started...", 0, /*number of emails to be sent*/);
                System.out.println("strCSVFrom=" + strCSVFrom + ", strcsvSendTo=" + strCSVSendTo);
                try{
                  br1=new BufferedReader(new FileReader(strCSVFrom));
                  br2=new BufferedReader(new FileReader(strCSVSendTo));
                  while((line1=br1.readLine())!=null){
                      countCSVFrom+=1;
                      String[] strarrFromEmail = line1.split(csvSplitBy);
                      strMailFrom=strarrFromEmail[0];
                      strPassword=strarrFromEmail[1];  
                      System.out.println("strFrom="+strMailFrom + ", strPassword="+strPassword);
                      countCSVSendTo=0;
                      while((line2=br2.readLine())!=null){
                         System.out.println("line2="+line2.toString());
                         countCSVSendTo+=1;
                         String[] strMailTo=line2.split("\n");
                         strSendTo=strMailTo[0];
                          String subject = "Test mail"; 
                          String message="";

                          //inline image
                          Map<String,String> inlineImage=new HashMap<String,String>();
                          inlineImage.put("image1", "Logo.jpg");

                          frmEmailer mailer = new frmEmailer();
                          String filename=txtHTMLFile.getText(); 
                          System.out.println("filename=" + filename);        
                          try{
                             message=mailer.readHTML(filename,message);
                             mailer.sendHtmlEmail(strhost, strport, strMailFrom, strPassword, strSendTo,
                                                 subject, message,inlineImage);
                             System.out.println("Email sent successfully.");
                             EmailCount++;
                             pm.setProgress(EmailCount);
                             pm.setNote("Sent " + EmailCount + " Mails.");
                             Random rand = new Random();
                             int randomNum = rand.nextInt((8 - 3) + 1) + 3;

                             System.out.println(randomNum);

                             Thread.sleep(randomNum*1000); //1000 microseconds = 1 seconds. 

                              if(countCSVSendTo==2){
                                 break;       
                              }
                          }catch (Exception ex) {
                              System.out.println("Failed to sent email.");
                              ex.printStackTrace();
                          }
                        }

                  //System.out.println("countcsvfrom="+countCSVFrom + ", line1=" + line1.toString());

                  System.out.println("countcsvsendto="+countCSVSendTo);
                  }
                  JOptionPane.showMessageDialog(null, "Emails sent successfully!");
                  btnSendEmailsNow.setEnabled(true);
                }catch(FileNotFoundException fnfe){
                      fnfe.printStackTrace();
                      JOptionPane.showMessageDialog(null, "Failed to send Email!");
                }catch(IOException ioe ){
                    JOptionPane.showMessageDialog(null, "Failed to send Email!");
                    ioe.printStackTrace();
                }
            }
    }.start();

    }