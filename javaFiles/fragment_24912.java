ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Filebeat\\filebeat.exe", "-c", "C:\\Program Files\\Filebeat\\filebeat.yml", "-e");
        pb.redirectErrorStream(true);
        Process p = pb.start();

        BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = bri.readLine()) != null) {
           System.out.println(line);
        }
        p.waitFor();