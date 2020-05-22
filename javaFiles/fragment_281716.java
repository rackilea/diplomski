198     Connection conn;
199     if ( driver != null ) {
200         // If a Driver is available, completely circumvent
201         // DriverManager#getConnection.  It attempts to double check
202         // ClassLoaders before using a Driver.  This does not work well in
203         // OSGi environments without wonky workarounds.
204         conn = driver.connect( url, connectionProps );
205     }
206     else {
207         // If no Driver, fall back on the original method.
208         conn = DriverManager.getConnection( url, connectionProps );
209     }
210     
211     if ( isolation != null ) {
212         conn.setTransactionIsolation( isolation.intValue() );
213     }
214     if ( conn.getAutoCommit() != autocommit ) {
215         conn.setAutoCommit(autocommit);
216     }