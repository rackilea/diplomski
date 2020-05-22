public CodingBatGUI() {
    initComponents();

    warmup1List.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                switch(warmup1List.getSelectedValue()) {
                    case "sleepIn":
                        descriptionTextArea.setText("This is a test.");
                        break;
                    case "monkeyTrouble":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "sumDouble":
                        descriptionTextArea.setText("This is another test");
                        break;    
                    case "diff21":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "parrotTrouble":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "makes10":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "nearHundred":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "posNeg":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "notString":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "missingChar":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "frontBack":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "front3":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "icyHot":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "in1020":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "hasTeen":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "loneTeen":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "delDel":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "mixStart":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "startOz":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "intMax":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "close10":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "in3050":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "max1020":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "stringE":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "lastDigit":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "endUp":
                        descriptionTextArea.setText("This is another test");
                        break;
                    case "everyNth":
                        descriptionTextArea.setText("This is another test");
                        break;
                    default: 
                        descriptionTextArea.setText("Nothing selected");  
                        break;
                }
            }
        }
    });