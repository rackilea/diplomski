public ArrayList<String> getAllCountriesCheck(String l) {
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement ps = null;
        String data;
        try {
            String ch=l+"%";
            ps = (PreparedStatement) dcon.con.prepareStatement("SELECT nicename FROM tbctry  WHERE nicename  LIKE '"+ch+"'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data = rs.getString("nicename");
                System.out.println(data);
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }