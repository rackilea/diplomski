@RestController
public class ShController{

    private Map<String, Process> shellMap = new HashMap<>();

    @GetMapping("/sh")
    public String shSessionCommand(@RequestParam String command, HttpSession session) throws IOException, InterruptedException {

        String result = "";
        Process process = getUserShell(session.getId());
        InputStream out = process.getInputStream();
        OutputStream in = process.getOutputStream();

        byte[] buffer = new byte[4000];
        boolean read = false;
        boolean written = false;
        while (!read) {
            int no = out.available();
            if (no > 0) {
                int n = out.read(buffer, 0, Math.min(no, buffer.length));
                result = new String(buffer, 0, n);
                read = true;
            }

            if(!written) {
                in.write((command + "\n").getBytes());
                in.flush();
                written = true;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
        }

        return result;
    }

    private Process getUserShell(String user) throws IOException {
        if(this.shellMap.get(user) == null){
            System.out.println("****Creating process");
            ProcessBuilder pb = new ProcessBuilder("sh", "-i");
            Process process = pb.start();
            shellMap.put(user, process);
        }
        return shellMap.get(user);
    }
}