IMOperation op = new IMOperation();
op.addRawArgs("compare"); //additional for imageMagick 7.0
op.metric("AE");
op.fuzz(1.0);
op.addImage(screenShotPath1);
op.addImage(screenShotPath2);
op.addImage(imageCompareResultFile.getAbsolutePath());

//Running compare.run(op) returns a difference file
//If it returns a difference file then the pictures are not the same and isSame is set to false
//If it returns an error then the pictures are the same and isSame is set to true

try {
    compare.run(op);
} catch (IOException e1a) {
    e1a.printStackTrace();
    Reporter.log("--Got error "+e1a.getMessage().toString(), true);
        } catch (InterruptedException e1b) {
            e1b.printStackTrace();
            Reporter.log("--Got error "+e1b.getMessage().toString(),true);
        } catch (IM4JavaException e1c) {
            e1c.printStackTrace();
            Reporter.log("--Got error "+e1c.getMessage().toString(),true);
        }

        IMOperation op2 = new IMOperation();
        Reporter.log("--Compare the differences file produced by compare command to see if there are differences or if the pics are the same.", true);
        op2.addRawArgs("compare"); //additional for imageMagick 7.0
        op2.channel("red");
        op2.metric("PSNR");
        op2.addImage(screenShotPath1);
        op2.addImage(screenShotPath2);
        op2.addImage(imageCompareResultFile.getAbsolutePath());
        try {
            compare.run(op2);
        } catch (IOException e2a) {
            // TODO Auto-generated catch block
            e2a.printStackTrace();
            Reporter.log("--Got error "+e2a.getMessage().toString(), true);
        } catch (InterruptedException e2b) {
            // TODO Auto-generated catch block
            e2b.printStackTrace();
            Reporter.log("--Got error "+e2b.getMessage().toString(), true);
        } catch (IM4JavaException e2c) {
            // TODO Auto-generated catch block
            e2c.printStackTrace();
            Reporter.log("--Got error "+e2c.getMessage().toString(), true);
            howDifferent = e2c.getMessage().toString();
        }

        Reporter.log("--If imagemagick returns an exception with a value returned, split the exception and the value apart by the : into an array to use for checking later.", true);
        Reporter.log("--imagemagick returns nothing, null, or inf if pics are same", true);
        Reporter.log("--imagemagick returns a decimal number if pics are different", true);

if (howDifferent == "")
        {
            //returns blank if pics are the same
            isSame=true;
            Reporter.log("--image compare the amount of differences is not greater than 0: blank is returned.", true);
        }
        else if (howDifferent == null)
        {
            //returns null if pics are the same
            isSame=true;
            Reporter.log("--image compare the amount of differences is not greater than 0: null is returned.", true);
        }
        else 
        {
             String [] errarray = howDifferent.split(":");
             try
             {
                    //Getting error org.im4java.core.CommandException: 3.50752
                    //returns >0 if pics are different
                    differentValue = Double.parseDouble(errarray[1]); 
                    if (differentValue > 0)
                    {
                        isSame=false;
                        Reporter.log("--image compare the amount of differences is greater than 0: differentValue is " +differentValue+ ".", true);
                    }
               }
               catch (NumberFormatException ex)
               {
                    //Getting error org.im4java.core.CommandException: inf
                    //returns inf if pics are the same
                    if(howDifferent.contains("inf"))
                    {
                      isSame=true;
                      Reporter.log("--image compare the amount of differences is not greater than 0: inf is returned.", true);
                    }

                }
        }