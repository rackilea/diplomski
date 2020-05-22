rs = pst.executeQuery(getId);
if (rs.next()) {
        int lastid = rs.getInt("id");
        rs.close();
        pst=conn.prepareStatement(Sql);
        pst.setString(2,txt_lessonTitle.getText());
        pst.setInt(3,lastid);
        pst.setString(4,txt_lessonContent.getText());

        pst.executeUpdate();
}