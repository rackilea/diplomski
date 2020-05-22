public List<PackSummary> getPackSummary(String groupID, java.sql.Date startDate, java.sql.Date endDate) {

    List<PackSummary> packSummaryList = new ArrayList<PackSummary>();
    PreparedStatement ps = null;
    // Create connection/statement variables outside of try block
    Connection c = null;

    String selectQry = ("SELECT 'Bronze Boomerang' as metric, COUNT(at_cub_awards.ca_id) as metricCount " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Bronze Boomerang%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Silver Boomerang', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Silver Boomerang%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Gold Boomerang', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Gold Boomerang%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Grey Wolf', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Grey Wolf%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Level 1', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Level 1%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Level 2', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_name LIKE '%Level 2%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Special', COUNT(at_cub_awards.ca_id) " +
            "FROM at_cub_details, at_cub_awards, at_award " + 
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
            "  AND at_cub_awards.ca_awarded_date >= ? " +
            "  AND at_cub_awards.ca_awarded_date <= ? " +
            "  AND at_cub_awards.aw_id = at_award.aw_id " +
            "  AND at_award.aw_award_type LIKE '%Special Interest%' " +
            "GROUP BY at_award.aw_award_type " +
            "UNION " +
            "SELECT 'Joined', COUNT(at_cub_details.cd_id) " +
            "FROM at_cub_details, at_section_details " +
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_section_details.cd_id " +
            "  AND at_section_details.sd_start_date >= ? " +
            "  AND at_section_details.sd_start_date <= ? " +
            "GROUP BY at_cub_details.grp_id " +
            "UNION " +
            "SELECT 'Left', COUNT(at_cub_details.cd_id) " +
            "FROM at_cub_details, at_section_details " +
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_id = at_section_details.cd_id " +
            "  AND at_section_details.sd_end_date >= ? " +
            "  AND at_section_details.sd_end_date <= ? " +
            "GROUP BY at_cub_details.grp_id " +
            "UNION " +
            "SELECT 'Current', COUNT(at_cub_details.cd_id) " +
            "FROM at_cub_details " +
            "WHERE at_cub_details.grp_id = ? " +
            "  AND at_cub_details.cd_archived IS NULL " +
            "GROUP BY at_cub_details.grp_id;");

    try {
        // Get Connection and Statement from DataSource
        c = ds.getConnection();
        ps = c.prepareStatement(selectQry);

        try {
            // Create a statement and execute the query on it               
            ps.setString(1, groupID);
            ps.setDate(2, (java.sql.Date) startDate);
            ps.setDate(3, (java.sql.Date) endDate);
            ps.setString(4, groupID);
            ps.setDate(5, (java.sql.Date) startDate);
            ps.setDate(6, (java.sql.Date) endDate);
            ps.setString(7, groupID);
            ps.setDate(8, (java.sql.Date) startDate);
            ps.setDate(9, (java.sql.Date) endDate);
            ps.setString(10, groupID);
            ps.setDate(11, (java.sql.Date) startDate);
            ps.setDate(12, (java.sql.Date) endDate);
            ps.setString(13, groupID);
            ps.setDate(14, (java.sql.Date) startDate);
            ps.setDate(15, (java.sql.Date) endDate);
            ps.setString(16, groupID);
            ps.setDate(17, (java.sql.Date) startDate);
            ps.setDate(18, (java.sql.Date) endDate);
            ps.setString(19, groupID);
            ps.setDate(20, (java.sql.Date) startDate);
            ps.setDate(21, (java.sql.Date) endDate);
            ps.setString(22, groupID);
            ps.setDate(23, (java.sql.Date) startDate);
            ps.setDate(24, (java.sql.Date) endDate);
            ps.setString(25, groupID);
            ps.setDate(26, (java.sql.Date) startDate);
            ps.setDate(27, (java.sql.Date) endDate);
            ps.setString(28, groupID);

            //Get result set
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                PackSummary packSummary = new PackSummary(result.getString("metric"), result.getInt("metricCount"));
                packSummaryList.add(packSummary);
            }

            // Clean up
            ps.close();
            c.close();

        } catch (SQLException se) {
            System.out.println("SQLException in getPackSummary: " + se.toString());
        } catch (Exception e) {
            System.out.println("Errors occurred in getPackSummary: " + e.toString());
        }

    } catch (SQLException e1) {
        System.out.println("SQLException in getPackSummary: " + e1.toString());
        e1.printStackTrace();

    } finally {

        // Ensure connection is closed and returned to the pool, even if errors occur.
        // This is *very* important if using a connection pool, because after all the
        // connections are used, the application will hang on getConnection(), waiting
        // for a connection to become available.
        // Any errors from the following closes are just ignored.  The main thing is
        // that we have definitely closed the connection.
        try { if(ps != null) ps.close(); } catch (Exception e) {}
        try { if(c != null) c.close(); } catch (Exception e) {}
    }
    // Done
    return packSummaryList;

}