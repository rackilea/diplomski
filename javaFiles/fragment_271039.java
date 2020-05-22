public class Login {
    private String userName;
    private String password;
    private String apiUrl;

    public Login() throws IOException{
        String token = "";

        Properties prop=new Properties();
        String LoginFileName="login.properties";

        InputStream inputStream =getClass().getClassLoader().getResourceAsStream(LoginFileName);
        if(inputStream!= null){
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("Property File"+LoginFileName+"not found in the classpath");

        }
        Date time= new Date(System.currentTimeMillis());
        System.out.println("Created at"+time);

        //get property values & print it out
        userName=prop.getProperty("user.name");
        password=prop.getProperty("password");
        apiUrl=prop.getProperty("api.url");
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}