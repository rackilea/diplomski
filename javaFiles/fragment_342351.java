public static void liveRtmpFeed() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i",
                "rtmp://192.168.0.90/oflaDemo/livestream", "-ss", "00:00:00",
                "-t", "00:00:10", "-c", "copy", "/home/outputVideo.mp4");
        Process process = processBuilder.start();
        InputStream stderr = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        while ((br.readLine()) != null)
            ;
        process.waitFor();

        try {
            process.destroy();
            isr.close();
            stderr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }