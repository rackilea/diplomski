public class Test {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "start", "mystuff.exe");
        Map<String, String> envs = pb.environment();
        System.out.println(envs.get("Path"));
        envs.put("Path", "C:\\mystuff");
        pb.redirectErrorStream();
        pb.start();

    }

}