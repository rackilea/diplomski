public enum EnumTest {

    BRONZE, SILVER;

    public String getProperty(String keyOrCode) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("E:\\EnumMapper.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(this.name() + "." + keyOrCode);
    }

    public String getCode() {
        return getProperty("CODE");
    }

    public String getKey() {
        return getProperty("KEY");
    }

    public static void main(String[] args) {
        System.out.println(EnumTest.BRONZE.getCode());
        System.out.println(EnumTest.BRONZE.getKey());

    }

}