while(rs.next()) {
    final String order_num = rs.getString("order_num");
    // System.out.println(order_num);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        model.addRow(new Object[]{order_num});
      }      
    });
}