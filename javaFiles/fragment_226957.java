ProcessBuilder builder = new ProcessBuilder();
builder.command(path + "/ffmpeg/ffmpeg.exe",
        "-i",
        path + "/audio/test.mpga",             
        path + "/audio/test.ogg");
builder.redirectErrorStream(true);