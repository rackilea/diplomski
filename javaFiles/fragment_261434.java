// Proper PreparedStatement example.
PreparedStatement pstmt = con.prepareStatement("DELETE FROM tender.bidder WHERE bidder.b_id = ?");
pstmt.setString(1, bidtxt.getText());
int i = pstmt.executeUpdate();

// String values need '' quotes.
Statement s = con.createStatement();
s.executeUpdate("DELETE FROM tender.bidder WHERE bidder.b_id = '"+bidtxt.getText()+"'");