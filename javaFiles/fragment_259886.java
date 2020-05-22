String a=(String) (table.getValueAt(j,1));
Float echantillons= Float.parseFloat(a);

PreparedStatement stmt = connection.prepareStatement(
        "insert into testing (echantillions) values (?)");

stmt.setFloat(1, echantillions);
int rs = stmt.executeUpdate();