while(rs.next()){
    PositionWrapper position = new PositionWrapper();
    position.setId(rs.getInt("Position_ID"));
    position.setPosition(rs.getString("Position"));
    JCB_Position.addItem(position);
}