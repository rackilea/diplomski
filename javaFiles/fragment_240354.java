private void updateMenu()
   {
      m_menu.removeAll();
      m_menu.add(new JMenuItem("1"));
      m_menu.add(new JMenuItem("2"));
      m_menu.add(new JMenuItem("3"));
      JPopupMenu popup = m_menu.getPopupMenu();
      popup.pack();
   }