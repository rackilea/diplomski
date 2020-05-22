stmt_update = conn_update.createStatement();
   stmt_update.executeUpdate("UPDATE Conference SET C_NAME = '" + confname + "', C_YEAR = " + yr
                + ", START_DATE = to_timestamp('" +stdate +"','yyyy-mm-dd HH24:MI:ss.FF1'), END_DATE = to_timestamp('" +enddate +"','yyyy-mm-dd HH24:MI:ss.FF1'),"
                + "COUNTRY = '"+country_update+"', CITY = '"+city_update+"', VENUE = '"+venue_update+"',"
                + ",  CONTACT_EMAIL = '"+c_email_update+"' where conference_id = '" + confid + "'");
                   __ Here one extra comma is exist.