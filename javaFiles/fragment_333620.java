int receivedData = Integer.parseInt( textField_?.getText() );
int pcuData = Integer.parseInt( textField_?.getText() );

pst.setInt(?, receivedData);
pst.setInt(?, pcuData);
...
pst.setInt(8, receivedData + pcuData);