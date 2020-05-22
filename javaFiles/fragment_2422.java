String add1 = rs.getString("Yapılan İşlem");
jTextField2.setText(add1);

could be with success

jTextField2.setText((rs.getString("Yapılan İşlem")).trim());