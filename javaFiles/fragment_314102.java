for (int col = 0; col < table.getColumnCount(); col++)
   {
     Rectangle rect = item.getBounds(col);
     if (rect.contains(pt))
      {
        System.out.println("The WindowID is" + item.getText(1));

        table.removeAll();

        repopulateTable();

        // Stop loop now, further reference to 'item' is invalid
        break;
      }
   }