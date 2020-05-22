ResultSet rs2=selcod.executeQuery("select nombre, apellidos, edad, calle, numero, codigopostal from alumnos where clave="+comboBox.getSelectedItem());
            txtNombre1.setText(rs2.getString(2));
            txtApellidos1.setText(rs2.getString(3));
            txtEdad1.setText(rs2.getString(4));
            txtCalle1.setText(rs2.getString(5));
            txtNumero1.setText(rs2.getString(6));
            txtCP1.setText(rs2.getString(7));