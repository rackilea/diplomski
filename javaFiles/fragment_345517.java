String sql= "INSERT INTO PROGETTO.CARRELLO (ISBN, DISPONIBILITA, TITOLO, CASA_EDITRICE, CODICE_AUTORE, GENERE, PREZZO)"
                + "VALUES (?,?,?,?,?,?,?)  where isbn=?";

        pst=(OraclePreparedStatement) conn.prepareStatement(sql);

        pst.setString (1, agg_libro_carr.getText());