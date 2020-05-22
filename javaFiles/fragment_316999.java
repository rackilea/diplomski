public int countCategoryPosts(int ncatID) throws Exception{
    int catID = ncatID;
    int result = 0;
    try{
        sql = "SELECT COUNT(*) FROM crm_posts WHERE cat_id = ?";
        prep = conn.prepareStatement(sql);
        prep.setInt(1, catID);
        rs = prep.executeQuery();
        if (rs.next()) {
           result = rs.getInt(1);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return result;
}