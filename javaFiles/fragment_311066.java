private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        // coding for webcam and taking a picture
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try
        {
            //start of the webcam for taking the picture
            grabber.start();
            //grabs teh image taken from the webcam
            IplImage img = grabber.grab();            
            //checks if the webcam has taken the picture and if the picture if mot empty
            if(img != null)
            {
                //determines where to save the picture
                cvSaveImage("C:\\User1\\PrifilePicture\\"+lbl_StudnetLogin.getText()+".jpeg", img);                         
            }
            //stops the webcam            
            grabber.stop();
            //used to resize teh picture taken in order to display picture to the user      
            Image imeResize = ImageIO.read(new File("C:\\SalVentri\\PrifilePicture\\"+lbl_StudnetLogin.getText()+".jpeg"));
            //1st ---> width _______2sn ---> height
            lbl_Profile.setIcon(new ImageIcon(imeResize.getScaledInstance(155, 100, 100)));

        }
        catch (Exception e)
        {
            //displays error message if problem with webcam
            JOptionPane.showMessageDialog(null, "Problem accessing or using the Webcam!");
        }

    }