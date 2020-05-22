PreparedStatement pst = null;//declaration outside your if block

if (output.equals("A")) {
   pst = connextion.prepareStatement("Query1");//initialization inside your if block 
} else if (output.equals("B")) {
    pst = connextion.prepareStatement("Query2");//or initialization inside your else
}

pst.setString(1, qty1);
pst.setInt(2, qty2);