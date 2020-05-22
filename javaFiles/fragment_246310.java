class Test 
        static Driver driver5;
        static Driver driver6;

        static void init() throws Exception {
            ClassLoader cl5 = new URLClassLoader(new URL[] { new URL("file:lib/ojdbc15.jar") });
            driver5 = (Driver) cl5.loadClass("oracle.jdbc.driver.OracleDriver").newInstance();
            ClassLoader cl6 = new URLClassLoader(new URL[] { new URL("file:lib/ojdbc6.jar") });
            driver6 = (Driver) cl6.loadClass("oracle.jdbc.driver.OracleDriver").newInstance();
        }

        public static void main(String[] args) throws Exception {
            Properties props = new Properties();
            props.put("user", "user");
            props.put("password", "pwd");
            String url = "jdbc:oracle:thin:@host:1529:sid";
            Connection conn5 = driver5.connect(url, props);
            Connection conn6 = driver6.connect(url, props);
        }