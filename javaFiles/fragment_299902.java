while(rs.next()) {
            String field = rs.getString("Field");
            String type = rs.getString("type");
            String nullinfo = rs.getString("null");
            String key = rs.getString("key");
            String extra = rs.getString("extra");
            tableModel.addRow(new Object[]{field, type, nullinfo, key, extra});
        }