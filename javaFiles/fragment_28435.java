rs2 = st.executeQuery(s2);

boolean hadResults = false;

while (rs2.next()) {
    ccalist.add(rs2.getString("CCA"));
    hadResults = true;
}

if (!hadResults) {
    System.out.println("No combination!");
    //JOptionPane.showMessageDialog(null, "No combination found!");
}