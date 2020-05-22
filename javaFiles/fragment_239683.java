private final String User_role ="admin";

if(User_role.eguals(UserRole.getUser())){
    PreparedStatement st = session.connection().prepareStatement("{update tblUser user set user.user_role = ? where (Condition)}");
    st.setString(1,User_role );
    st.execute();
}