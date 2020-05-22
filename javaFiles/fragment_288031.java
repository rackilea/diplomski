public static List<Properties>  loadAllProperties() {
        File[] files = new File(System.getProperty("environment.config")).listFiles();
        List<Properties>  lstOfProperties = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filename = file.getName();
                    String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

                    if (("properties").equals(extension)) {
                        Properties props = new Properties();
                        try {
                            props.load(new FileReader(file));
                        } catch (IOException e) {
                            LOGGER.error("Loading Properties " , e);
                        }
                         lstOfProperties.add(props);
                    }
                }
            }
        }
        return lstOfProperties;
    }