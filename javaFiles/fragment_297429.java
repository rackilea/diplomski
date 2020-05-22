public static void main(String[] args) throws IOException, InterruptedException {
    String INPUT_FILE = "/path/to/media";
    String FFMPEG_PATH = "/path/to/ffmpegFolder";

    for (int i = 0; (i + 4) < 40; i += 4) {

        String command1 = String.format(
                "%s/ffmpeg_4.1.1 -nostdin -ss %d -t 4 -i '%s' -ac 1 -acodec pcm_s16le -ar 16000 -f nut -",
                FFMPEG_PATH, i, INPUT_FILE);

        String command2 = String.format(
                "%s/ffmpeg_4.1.1 -i - -lavfi showspectrumpic=s=128x75:legend=disabled:saturation=0:stop=8000",
                FFMPEG_PATH);

        Process process = new ProcessBuilder("sh", "-c", command1 + " | " + command2)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start();

        BufferedImage image = ImageIO.read(process.getInputStream());
        // ...
    }
}