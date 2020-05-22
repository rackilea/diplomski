public class UserActionVOMapper implements RowMapper<UserActionVO>(){
    @Override  
    public UserActionVO mapRow(ResultSet rs, int rownumber) throws SQLException {  
        UserActionVO userActionVO = new UserActionVO();  
        userActionVO.setUserId(rs.getString("USER_ID"));
        userActionVO.setUserName(rs.getString("USERNAME"));
        userActionVO.setPassword(rs.getString("PASSWORD"));
        userActionVO.setAgencia(rs.getString("AGENCIA"));
        userActionVO.setEmail(rs.getString("EMAIL"));
        userActionVO.setGrabadoPor(rs.getString("GRABADO_POR"));
        userActionVO.setMobileNumber(rs.getString("MOBILENUMBER"));
        userActionVO.setUserStatus(rs.getString("USER_STATUS"));
        userActionVO.setZone(rs.getString("ZONE"));
        userActionVO.setName(rs.getString("NAME"));
        userActionVO.setUserType(rs.getString("USER_TYPE")); 
        userActionVO.setUserRoleMappingId(rs.getInt("USERROLEMAPPING_ID"));
        userActionVO.setRoleId(rs.getInt("ROLE_ID"));
        userActionVO.setRoleName(rs.getString("ROLE_NAME"));
        userActionVO.setPriority(rs.getInt("PRIORITY"));
        userActionVO.setRoleActionId(rs.getInt("COMPONENT_ID"));
        userActionVO.setActionId(rs.getInt("ACTION_ID"));
        userActionVO.setActionName(rs.getString("ACTION_NMAE"));
        userActionVO.setComponentId(rs.getInt("COMPONENTID"));
        userActionVO.setComponentName(rs.getString("COMPONENTNAME"));
        userActionVO.setComponentIdentification(rs.getString("COMPONENTIDENTIFICATION"));
        userActionVO.setComponentState(rs.getString("COMPONENTSTATE"));
        return userActionVO;  
    }
}