public class DecodeMessage extends JFrame implements ActionListener
{
JButton open = new JButton("Open"), decode = new JButton("Decode"),
   reset = new JButton("Reset");
String[] rgbaList = { "B", "G", "R", "A" };
JComboBox<String> chooseRGBA = new JComboBox<>(rgbaList);
JTextArea message = new JTextArea(10,3);
BufferedImage image = null;
JScrollPane imagePane = new JScrollPane();

private void assembleInterface() {
   JPanel p = new JPanel(new FlowLayout());
   p.add(open);
   p.add(chooseRGBA);
   p.add(decode);
   p.add(reset);
   this.getContentPane().add(p, BorderLayout.NORTH);
   open.addActionListener(this);
   decode.addActionListener(this);
   reset.addActionListener(this);
   open.setMnemonic('O');
   decode.setMnemonic('D');
   reset.setMnemonic('R');

   p = new JPanel(new GridLayout(1,1));
   p.add(new JScrollPane(message));
   message.setFont(new Font("Arial",Font.BOLD,20));
   p.setBorder(BorderFactory.createTitledBorder("Decoded message"));
   message.setEditable(false);
   this.getContentPane().add(p, BorderLayout.SOUTH);

   imagePane.setBorder(BorderFactory.createTitledBorder("Steganographed Image"));
   this.getContentPane().add(imagePane, BorderLayout.CENTER);
   }

public void actionPerformed(ActionEvent ae) {
   Object o = ae.getSource();
   if(o == open)
      openImage();
   else if(o == decode){
      int rgbaChoice = chooseRGBA.getSelectedIndex(), sb = 0;
      if(rgbaChoice == 0)
         sb = 24;
      else if(rgbaChoice == 1)
         sb = 16;
      else if(rgbaChoice == 2)
         sb = 8;
      else if(rgbaChoice == 3)
         sb = 0;
      decodeMessage(sb);
      }
   else if(o == reset) 
      resetInterface();
   }

private void openImage() {
   java.io.File f = showFileDialog(true);
   try {   
      image = ImageIO.read(f);
      image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = image.createGraphics();
      g.drawImage(ImageIO.read(f), 0, 0, null);
      g.dispose();
      JLabel l = new JLabel(new ImageIcon(image));
      imagePane.getViewport().add(l);
      this.validate();
      } catch(Exception ex) { ex.printStackTrace(); }
   }

private void decodeMessage(int storageBit) {
   int len = extractInteger(image, 0, storageBit);
   byte b[] = new byte[len];
   for(int i=0; i<len; i++)
      b[i] = extractByte(image, i*8+32, storageBit);
   message.setText(new String(b));
   }

private byte extractByte(BufferedImage img, int start, int storageBit) {
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   byte b = 0;
   for(int i=startX; i<maxX && count<8; i++) {
      for(int j=startY; j<maxY && count<8; j++) {
         if(j==maxY-1){
            startY = 0;
            }
         int rgb = img.getRGB(i, j), bit = getBitValue(rgb, storageBit);
         b = (byte)setBitValue(b, count, bit);
         count++;
         }
      }
   return b;
   }