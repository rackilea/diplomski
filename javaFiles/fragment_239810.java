SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
java.sql.Date sqlDate = new java.sql.Date(jDateChooser1.getDate().getTime());

requete = "update humain set nom = ?, prenom=?, adresse=?, date_n=?, sex=? where id=?";
state = con.prepareStatement(requete);
updateSales.setString(1, jTextField2.getText());
updateSales.setString(2, jTextField3.getText());
updateSales.setString(3, jTextField4.getText());
updateSales.setDate(4, sqlDate);
updateSales.setString(5, radio);
updateSales.setString(6, jTextField1.getText());
state.executeUpdate(requete);