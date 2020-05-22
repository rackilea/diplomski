public void writeText(Object parameter) {
    Class<?> aClass = parameter.getClass();
    for (Field f : aClass.getDeclaredFields()) {
        if (f.getName().equals("logger")) {
            try {
                f.setAccessible(true);
                Logger log = (Logger) f.get(parameter);
                System.out.println(log.getText());  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}