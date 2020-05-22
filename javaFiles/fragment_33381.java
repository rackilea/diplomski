boolean isAlreadyOneClick=false;
...
    DefaultListModel xlistModel=new DefaultListModel();
    JList xlist=new JList(xlistModel);
    xlist.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        int index=xlist.locationToIndex(e.getPoint());
        String item=xlistModel.getElementAt(index).toString();

        if (SwingUtilities.isLeftMouseButton(e))
        {
          if (isAlreadyOneClick)
          {
            System.out.println("Left double click : "+item);
            isAlreadyOneClick=false;
          }
          else
          {
            isAlreadyOneClick=true;
            Timer t=new Timer("doubleclickTimer",false);
            t.schedule(new TimerTask()
            {
              @Override
              public void run()
              {
                if (isAlreadyOneClick) System.out.println("Left single click : "+item);
                isAlreadyOneClick=false;
              }
            },250);
          }              
        }
        else if (SwingUtilities.isRightMouseButton(e))
        {
          if (isAlreadyOneClick)
          {
            System.out.println("Right double click : "+item);
            isAlreadyOneClick=false;
          }
          else
          {
            isAlreadyOneClick=true;
            Timer t=new Timer("doubleclickTimer",false);
            t.schedule(new TimerTask()
            {
              @Override
              public void run()
              {
                if (isAlreadyOneClick) System.out.println("Right single click : "+item);
                isAlreadyOneClick=false;
              }
            },250);
          }
        }
      }
    });

    xlistModel.addElement("123");
    xlistModel.addElement("abc");
    JFrame f=new JFrame("Test Clicks");
    f.add(xlist);
    f.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent we) { } });
    f.setBackground(SystemColor.control);

    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);