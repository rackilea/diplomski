//Taking the query from a txt
String query = jTextPaneRequeteSql.getText();

try (Connection con = getConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery(query)) {

    // Initialisation request time
    long start = System.currentTimeMillis();

    //Little manipulation to get the number of row
    rs.last();
    int rowCount = rs.getRow();

    //Calculate the time
    long totalTime = System.currentTimeMillis() - start;

    rs.beforeFirst();
    //Get the model
    jTableRequeteSql.setModel(buildTableModel(rs));

    //display the time
    jLabelRequeteSql.setText("La requête à été exécuter en " + totalTime + " ms et a retourné " + rowCount + " ligne(s)");
    System.out.println("La requête à été exécuter en " + totalTime + " ms et a retourné " + rowCount + " ligne(s)");

    //Refresh the display
    jTableRequeteSql.revalidate();
    jTableRequeteSql.repaint();

} catch (SQLException e) {
    //Dans le cas d'une exception, on affiche une pop-up et on efface le contenu
    JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR ! ", JOptionPane.ERROR_MESSAGE);
}