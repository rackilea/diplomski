class Test{

    public static void main(final String... arguments) throws Exception{

        File file=new File("\\\\.\\\\.\\C:\\Temp\\AUX");

        file.mkdir();
        System.out.println(file.isDirectory());
        file.delete();

        Process p = Runtime.getRuntime().exec("cmd /c md \\\\.\\\\C:\\Temp\\AUX");
        p.waitFor();
        System.out.println(file.isDirectory());
        Runtime.getRuntime().exec("cmd /c rd \\\\.\\\\C:\\Temp\\AUX");

    }

}