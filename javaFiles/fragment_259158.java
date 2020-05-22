class User{
    private String id;
    private String age;
    private String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}    


class DateAccess{   
    public User getUserInfo(String id){   
        User user= new User();
        String sql ="select id,name ,age from user where id =?";
        ResultSet rs = query(sql,id);
        while(rs!=null&&rs.next()){
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getString("age"));
        }
        return user;
  }
}