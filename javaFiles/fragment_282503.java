Connection con = getMyConnection();
    try {
        PreparedStatement ps = con.prepareStatement("select * from TableA where num = ?");
        try {
            ps.setLong(1, number);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //TODO
            }
        } finally {
            ps.close();
        }
    } finally {
        con.close();
    }