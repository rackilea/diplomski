@Override
public List<UserActionVO> getUserTest(String username) {

    final List<UserActionVO> userActionVOs = null;

    String query="SELECT um.USER_ID, um.USERNAME, um.PASSWORD,  um.AGENCIA,  um.EMAIL, um.GRABADO_POR,  um.MOBILENUMBER,  um.USER_STATUS,  um.ZONE,  um.NAME, um.USER_TYPE,  urmm.USERROLEMAPPING_ID,  r.ROLE_ID,  r.ROLE_NAME,  r.PRIORITY,  rcmm.COMPONENT_ID,  am.ACTION_ID,  am.ACTION_NMAE,  cm.COMPONENTID,  cm.COMPONENTNAME,  cm.COMPONENTIDENTIFICATION, cm.COMPONENTSTATE FROM USER_MASTER um,  role r, USER_ROLE_MAPPING_MASTER urmm, ACTION_MASTER am, ROLE_COMPONENT_MAPPING_MASTER rcmm, ACTION_COMPONENT_MAPPINGMASTER acm,COMPONENT_MASTER cm WHERE upper(um.USERNAME)=upper(?) AND um.USER_ID          =urmm.USER_ID AND urmm.ROLE_ID        =r.ROLE_ID AND r.ROLE_ID           =rcmm.ROLE_ID AND urmm.ROLE_ID        =rcmm.ROLE_ID AND acm.ACTION_ID       =am.ACTION_ID AND rcmm.COMPONENT_NAME =acm.COMPONENT_NAME AND acm.COMPONENT_NAME=cm.COMPONENTNAME(+)";
    System.out.println("in dao");

    try{
        userActionVOs  = getJdbcTemplate().query(query, new Object[] { username }, new UserActionVOMapper());

    }catch(Exception e){
        e.printStackTrace();
    }

    return userList;
}