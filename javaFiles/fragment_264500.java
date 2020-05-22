try {
            Properties prop = new Properties();
            String[] orbarg = new String[2];

            try {
                // load a properties file
                prop.load(new FileInputStream("config.properties"));
                // get the property value and print it out  
                orbarg[0] = "-ORBInitRef"; // <---- NEEDED
                orbarg[1] = prop.getProperty("ORBInitRef");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            ORB orb = ORB.init(orbarg,null);