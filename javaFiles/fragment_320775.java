ResultSet rs2=selcod.executeQuery("select nombre, apellidos, edad, calle, numero, codigopostal from alumnos where clave="+comboBox.getSelectedItem());
          if(rs2.next()){
            txtNombre1.setText(rs2.getString(1));
            txtApellidos1.setText(rs2.getString(2));
            txtEdad1.setText(rs2.getString(3));
            txtCalle1.setText(rs2.getString(4));
            txtNumero1.setText(rs2.getString(5));
            txtCP1.setText(rs2.getString(6));
          }