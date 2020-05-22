Properties section = null;
    String line = null;
    while ((line = br.readLine()) != null) {
        if (line.startsWith("[") && line.endsWith("]")) {
            section = new Properties();
            this.config.put(line.substring(1, line.length() - 1), section);
        } else if (line.contains("=") && !line.startsWith("#")) {
            String[] keyValue = line.split("=");
            section.setProperty(keyValue[0], keyValue[1]);
        }
    }