Connection con = ...;
con.setAutoCommit(false);

Statement stmt = con.createStatement();
stmt.executeUpdate("INSERT INTO CARS (CARNR) VALUES (" + (getLetzteFahrzeugNr() +1)+ ")");
stmt.executeUpdate("INSERT INTO KAUFINFO (CARNR) VALUES (" + (getLetzteFahrzeugNr() +1)+ ")");
stmt.executeUpdate("INSERT INTO POSITIONS (CARNR) VALUES (" + (getLetzteFahrzeugNr() +1)+ ")");

con.commit();