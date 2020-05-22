String SQL = "{CALL ? = BeerBeer.getBreweryInfo (?)}";
        stmt = conn.prepareCall(SQL);
        int Raz_ID = 4;
        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.setInt(2, Raz_ID);
        System.out.println("Izpildam JAVA glabajamo proceduru ...");
        // Vaicājuma izpilde
        stmt.execute();
        //Izgustam Alus_razotaja nosaukumu ar getXXX metodi.
        String Razotajs = stmt.getString(1);