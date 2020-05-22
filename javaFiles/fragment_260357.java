if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.toString();
                image = new JLabel(new ImageIcon(fileName));
                imgPanel.add(image);
                frame.add(imgPanel, BorderLayout.WEST);
                frame.repaint();
                frame.validate();
     }