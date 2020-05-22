String query = "UPDATE word 
                SET urlid = CASE WHEN FIND_IN_SET( ?, urlid ) > 0 THEN urlid 
                            ELSE CONCAT( urlid, ',', ? )
                            END 
                WHERE word = ? ";

PreparedStatement pst = con.prepareStatement( query );

pst.setString( 1, urlid );
pst.setString( 2, urlid );
pst.setString( 3, item);

int result = pst.executeUpdate();