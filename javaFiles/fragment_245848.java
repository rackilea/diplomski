public boolean loginValidate(Login login) {

Boolean check=false;

         if(login!=null){
       LoginDAO ld=new LoginDAO();
       DataSource dataSource=new DataSource();
       ld.setDataSource(dataSource);
        check=ld.validate(login);
       }
return check;
    }