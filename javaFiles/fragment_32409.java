public Map<String, Integer> beam_CurrentStatus() throws SQLException {
    Map<String, Integer> map = new HashMap<>();
    try {
        con = getConnection();
        stmt = con.createStatement();

        String sql = "SELECT TOP 1 c.logtime, a.BL1_data_SS_ST,a.BL2_data_SS_ST,a.BL3_data_SS_ST,a.BL4_data_SS_ST,a.BL5_data_SS_ST,a.BL6_data_SS_ST,a.BL7_data_SS_ST,a.BL8_data_SS_ST,a.BL9_data_SS_ST,a.BL10_data_SS_ST,a.BL11_data_SS_ST, a.BL12_data_SS_ST,a.BL13_data_SS_ST,a.BL14_data_SS_ST,a.BL15_data_SS_ST,a.BL16_data_SS_ST,a.BL17_data_SS_ST,a.BL18_data_SS_ST,a.BL19_data_SS_ST,a.BL20_data_SS_ST,a.BL21_data_SS_ST,a.BL22_data_SS_ST,a.BL23_data_SS_ST,a.BL24_data_SS_ST,a.BL25_data_SS_ST,a.BL26_data_SS_ST,a.BL27_data_SS_ST,b.st1_prmt_status_p45,c.beam_current,c.beam_energy from INDUS2_BLFE.dbo.main_BLFE_status a inner join INDUS2_MSIS.dbo.main_MSIS_status b on a.logtime=b.logtime inner join INDUS2_BDS.dbo.DCCT c on b.logtime=c.logtime ORDER BY c.logtime DESC ";

        stmt.executeQuery(sql);
        rs = stmt.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            for (int j = 2; j < 30; j++) {
                if (rs.getInt(j) == 1) {
                    String name = rsmd.getColumnLabel(j);
                    map.put(name, rs.getInt(j));
                }
            }
        }
    } catch (Exception e) {
        System.out.println("\nException in  Bean " + e.getMessage());
    } finally {
        closeConnection(stmt, rs, con);
    }
    return map;
}