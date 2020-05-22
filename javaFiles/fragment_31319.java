public static void main(String[] args) {
     Properties prop = new Properties();
     try {
        String path=System.getenv("APPDATA");
          path=path.substring(0,path.lastIndexOf('\\')+1)+"LocalLow\\Sun\\Java\\Deployment\\deployment.properties";
            System.err.println(path);

            prop.load(new FileInputStream(path));
            String jreIndex = null; 
            Enumeration enuKeys = prop.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = prop.getProperty(key);
                if(value.contains("1.6.0_26")){
                    String[] st2 = key.split("\\.");  
                    if(st2.length==5){
                        jreIndex = st2[3];
                    }
                }
            }
            //SystemSettings SysConfigsettings = new SystemSettings();
            if(jreIndex != null){
            //  if (SysConfigsettings.getValue(SystemSettings.JRE_HEAP_SIZE))
              {
                prop.setProperty("deployment.javaws.jre."+jreIndex+".args", "-Xmx1024m");
              }
            }
            prop.store(new FileOutputStream(path), "UpdatedHeapSize");
            System.out.println("First : "+prop.getProperty("deployment.javaws.jre.0.args"));
    } catch (Exception e) {
        e.printStackTrace();
    }