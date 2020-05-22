public class EmbedMessage extends JFrame implements ActionListener
{
JButton open = new JButton("Open"), embed = new JButton("Embed"),
   save = new JButton("Save into new file"), reset = new JButton("Reset");
String[] rgbaList = { "B", "G", "R", "A" };
JComboBox<String> chooseRGBA = new JComboBox<>(rgbaList);
JTextArea message = new JTextArea(10,3);
BufferedImage sourceImage = null, embeddedImage = null;
JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
JScrollPane originalPane = new JScrollPane(),
   embeddedPane = new JScrollPane();

private void assembleInterface() {
   JPanel p = new JPanel(new FlowLayout());
   p.add(open);
   p.add(chooseRGBA);
   p.add(embed);
   p.add(save);   
   p.add(reset);
   this.getContentPane().add(p, BorderLayout.SOUTH);
   open.addActionListener(this);
   embed.addActionListener(this);
   save.addActionListener(this);   
   reset.addActionListener(this);
   open.setMnemonic('O');
   embed.setMnemonic('E');
   save.setMnemonic('S');
   reset.setMnemonic('R');

   p = new JPanel(new GridLayout(1,1));
   p.add(new JScrollPane(message));
   message.setFont(new Font("Arial",Font.BOLD,20));
   p.setBorder(BorderFactory.createTitledBorder("Message to be embedded"));
   this.getContentPane().add(p, BorderLayout.NORTH);

   sp.setLeftComponent(originalPane);
   sp.setRightComponent(embeddedPane);
   originalPane.setBorder(BorderFactory.createTitledBorder("Original Image"));
   embeddedPane.setBorder(BorderFactory.createTitledBorder("Steganographed Image"));
   this.getContentPane().add(sp, BorderLayout.CENTER);
   }

public void actionPerformed(ActionEvent ae) {
   Object o = ae.getSource();
   if(o == open)
      openImage();
   else if(o == embed){
      int rgbaChoice = chooseRGBA.getSelectedIndex(), sb = 0;
      if(rgbaChoice == 0)
         sb = 24;
      else if(rgbaChoice == 1)
         sb = 16;
      else if(rgbaChoice == 2)
         sb = 8;
      else if(rgbaChoice == 3)
         sb = 0;
      embedMessage(sb);
      }
   else if(o == save) 
      saveImage();
   else if(o == reset) 
      resetInterface();
   }

private void openImage() {
   java.io.File f = showFileDialog(true);
   try {   
      sourceImage = ImageIO.read(f);
      sourceImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = sourceImage.createGraphics();
      g.drawImage(ImageIO.read(f), 0, 0, null);
      g.dispose();
      JLabel l = new JLabel(new ImageIcon(sourceImage));
      originalPane.getViewport().add(l);
      this.validate();
      } catch(Exception ex) { ex.printStackTrace(); }
   }

private void embedMessage(int storageBit) {
   String mess = message.getText();
   embeddedImage = sourceImage.getSubimage(0,0,
      sourceImage.getWidth(),sourceImage.getHeight());
   embedMessage(embeddedImage, mess, storageBit);
   JLabel l = new JLabel(new ImageIcon(embeddedImage));
   embeddedPane.getViewport().add(l);
   this.validate();
   }

private void embedMessage(BufferedImage img, String mess, int storageBit) {
   int messageLength = mess.length();

   int imageWidth = img.getWidth(), imageHeight = img.getHeight(),
      imageSize = imageWidth * imageHeight;
   if(messageLength * 8 + 32 > imageSize) {
      JOptionPane.showMessageDialog(this, "Message is too long for the chosen image",
         "Message too long!", JOptionPane.ERROR_MESSAGE);
      return;
      }
   embedInteger(img, messageLength, 0, storageBit);

   byte b[] = mess.getBytes();
   for(int i=0; i<b.length; i++)
      embedByte(img, b[i], i*8+32, storageBit);
   }