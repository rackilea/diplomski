public String LookUpTransaction() {
        List list=new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank", "root", "root");
            PreparedStatement ps = con
                    .prepareStatement("select accountno,details,amount from transaction");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] strarray = new String[list.size()];
        strarray = list.toArray(strarray);
        return Arrays.toString(strarray);
    }