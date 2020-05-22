final Path videoIn = Paths.get("c:\\ffmpeg\\bin\\input.mp4");
final Path encodingFile = Paths.get("c:\\ffmpeg\\bin\\output.mp4");
final Path errorFile = Paths.get("c:\\ffmpeg\\bin\\error.txt");

int retCode;

try {
    Files.deleteIfExists(encodingFile);
    Files.deleteIfExists(errorFile);

    final ProcessBuilder pb 
        = new ProcessBuilder("c:\\ffmpeg\\bin\\ffmpeg.exe",
            "-i", videoIn.toString(),
            "-y", 
            "-s", "360x480", // stripped the extraneous "-1"
            "-vcodec", "libx264",                    
            "c:\\ffmpeg\\bin\\output.mp4"
    ); //or other command....

    pb.redirectError(errorFile.toFile());
    pb.redirectOutput(encodingFile.toFile());

    final Process p = pb.start();

    // CHECK FOR THIS!
    retcode = p.waitFor();

    // Reproduced here; not sure this is anything useful,
    // since the old code, just like this one, just reads the contents
    // from the video file to be converted... Huh?
    final byte[] videoIn = Files.readAllBytes(videoIn);
} catch (IOException e) {
    // deal with e here
}