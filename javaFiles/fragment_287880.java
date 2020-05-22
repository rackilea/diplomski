String sql = "INSERT INTO student_ ( first_name_ , … , clock_in_ , clock_out_ ) VALUES ( ? , … , ? , ? ) ; " ;
PreparedStatement ps = conn.prepareStatement( sql ) ;
ps.setString( 1 , 'Ben' ) ;
…
ps.setObject( … , in ) ;
ps.setObject( … , out ) ;
…