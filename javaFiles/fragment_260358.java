////don't repeate this code block
image = new JLabel();
imgPanel.add(image);
frame.add(imgPanel, BorderLayout.WEST);
frame.repaint();
frame.validate();
/////////

  if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.toString();
                image.setIcon(new ImageIcon(fileName )); 
                //repaint
                frame.repaint();

   }