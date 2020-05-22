class TextTab extends JPanel
     {
        String[] textOptions = new String[]{"1 line of text","2 lines of text","3 lines of text","Chest Name","Script with Tail (1 Color)","Script with Tail (2 Color)"};
        String[] numberOptions = new String[]{"1\"","2\"","3\"","4\"","6\"","8\"","10\""};
        CustomJList<String> textList = new CustomJList<String>(textOptions);
        CustomJList<String> numberList = new CustomJList<String>(numberOptions);
        GridBagLayout ttGlay = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        NimbusCellRenderer cr = new NimbusCellRenderer();
        JPanel pnl = new JPanel(new GridBagLayout());
        JScrollPane textNumOptionsPane = new JScrollPane(pnl);

        public TextTab()
        {
           ttGlay.rowHeights = new int[]{0,137};  

           textList.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED),"Standard Text"));
           numberList.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED),"Pre-Cut Numbers"));
           textList.setOpaque(false);
           textList.setCellRenderer(cr);
           numberList.setOpaque(false);
           numberList.setCellRenderer(cr);
           textList.setBackground(Color.WHITE);
           numberList.setBackground(Color.WHITE);
           textList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           numberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

           setLayout(ttGlay);
           gbc.weightx = 1;
           gbc.weighty = 1;

           gbc.gridx = 0;
           gbc.gridy = 0;
           gbc.anchor = gbc.NORTH;
           gbc.fill = gbc.BOTH;
           gbc.gridwidth = 1;
           gbc.gridheight = 1;
           gbc.insets = new Insets(10,10,0,0);
           add(textList,gbc);

           gbc.gridx = 1;
           gbc.gridy = 0;
           gbc.anchor = gbc.NORTH;
           gbc.fill = gbc.BOTH;
           gbc.gridwidth = 1;
           gbc.gridheight = 1;
           gbc.insets = new Insets(10,0,0,10);
           add(numberList,gbc);

           gbc.gridx = 0;
           gbc.gridy = 1;
           gbc.anchor = gbc.NORTH;
           gbc.fill = gbc.BOTH;
           gbc.gridwidth = 2;
           gbc.gridheight = 1;
           gbc.insets = new Insets(0,10,10,10);
           add(textNumOptionsPane,gbc);
        }

        class CustomJList<E> extends JList<E>
        {
           public CustomJList(){super();}
           public CustomJList(E[] listData){super(listData);}
           public CustomJList(ListModel<E> dataModel){super(dataModel);}
           public CustomJList(Vector<? extends E> listData){super(listData);}

           @Override
           public void paint(Graphics g)
           {
              Graphics2D g2 = (Graphics2D)g.create();
              g2.setColor(getBackground());
              if(!isOpaque())g2.fillRect(getInsets().left-4,getInsets().top-4,getWidth()-getInsets().left-getInsets().right+8,getHeight()-getInsets().top-getInsets().bottom+8);
              super.paint(g);
           }
        }

        class NimbusCellRenderer extends JLabel implements ListCellRenderer<Object>
        {
           public NimbusCellRenderer()
           {
              setOpaque(true);
           }

           public Component getListCellRendererComponent(JList<?> list,Object value,int index,boolean isSelected,boolean cellHasFocus)
           {
              setBorder(new EmptyBorder(0,5,0,0));
              setText(value.toString());
              Color background;
              Color foreground;

              if (isSelected&&list.hasFocus())
              {
                 background = new Color(57,105,138);
                 foreground = Color.WHITE;
              }
              else
              {
                 background = Color.WHITE;
                 foreground = Color.BLACK;
              }

              if(list.hasFocus()&&isSelected)
              {
                 setBorder(new CompoundBorder(new CompoundBorder(new LineBorder(new Color(115,164,209),1),new LineBorder(new Color(72,120,155),1)),new EmptyBorder(0,3,0,0)));
              }

              setBackground(background);
              setForeground(foreground);
              return this;
           }
        }
     }