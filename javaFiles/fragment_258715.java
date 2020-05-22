public List getComNotify(ObsBean Comname) {
    List<ObsBean> comNotify = new ArrayList<ObsBean>();
    String COM = Comname.getcompanyname();
    try {
        String sql = "SELECT * from ObsNotify where notto='"+COM+"'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            ObsBean userNotify = new ObsBean();
            int totalRows = rs.getRow();

            userNotify.setNotifyName(rs.getString("notname"));
            userNotify.setNotifyBy(rs.getString("notby"));

            comNotify.add(userNotify);
        }
    } 
    catch (Exception e) {
        out.print("Error for User Notification - : "+e);
    }
    return comNotify; 
}