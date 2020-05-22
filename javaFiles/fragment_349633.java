public void getSum() {

         Connection con =getConnection();
         Statement st;
         PreparedStatement pst = null;
         ResultSet rs;
        try{
            String qquery=" SELECT sum(Receipt.Sales_Quantity * Receipt.Pro_Price) AS TotalItemsOrdered FROM Receipt";
          pst=con.prepareStatement(qquery);
                         //pst.setString(1,qquery );
                         rs=pst.executeQuery();

         if(rs.next()){
              float TotalItemsOrdered = rs.getFloat("TotalItemsOrdered");
              float nvNum=TotalItemsOrdered;
             sum_calc.setText(valueOf(nvNum));
       JOptionPane.showMessageDialog(null, rs);

         }else{
            JOptionPane.showMessageDialog(null, "Not Found");
        }

    }catch (Exception e) { JOptionPane.showMessageDialog(null, e); }

}