ArrayList<String> xmllist= new ArrayList<>();
Map<String,Icon> amap = new HashMap<>();

if(g.getName().endsWith("png") ||g.getName().endsWith("jpg") ) {

try {
       DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                   jTree1.getLastSelectedPathComponent();

    Object nodeInfo = node.getUserObject();
    String hn = imagePathTextBox.getText();

    Image img = ImageIO.read(new File(hn)) ;  
    Image newimg = img.getScaledInstance( 28, 28,  java.awt.Image.SCALE_SMOOTH ) ;  
    Icon x = new ImageIcon(newimg);
    amap.put(nodeInfo.toString() , x);

     jTree1.setCellRenderer(new DefaultTreeRenderer(xmllist,amap));
    } catch (IOException ex) {
        Logger.getLogger(frame.class.getName()).log(Level.SEVERE , null , ex);
    }
  }