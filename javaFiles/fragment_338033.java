ffmpeg = new FFmpeg("D:/ffmpeg-20180429-cae6f80-win32-static/ffmpeg-20180429-cae6f80-win32-static/bin/ffmpeg");
ffprobe = new FFprobe("D:/ffmpeg-20180429-cae6f80-win32-static/ffmpeg-20180429-cae6f80-win32-static/bin/ffprobe");

FFmpegBuilder builder = new FFmpegBuilder()
                                 .setInput(input)     // Filename, or a FFmpegProbeResult
                                 .overrideOutputFiles(true) // Override the output if it exists
                                 .addOutput(output)   // Filename for the destination
                                 .setFormat("mp4")       // Format is inferred from filename, or can be set
                             //  .setTargetSize(250_000) // Aim for a 250KB file
                                 .disableSubtitle()       // No subtiles
                                 .setAudioChannels(1)                   // Mono audio
                             //  .setAudioChannels(2)
                                 .setAudioCodec("aac")       // using the aac codec
                                 .setAudioSampleRate(48_000) // at 48KHz
                                 .setAudioBitRate(32768)     // at 32 kbit/s
                             //  .setAudioBitRate(126000)
                                 .setVideoCodec("libx264")     // Video using x264             
                                 .setVideoFrameRate(24, 1)     // at 24 frames per second
                                 .setVideoResolution(1280, 720) // at 640x480 resolution
                        //       .setVideoResolution(1024, 768)
                        //       .setVideoResolution(640, 480)
                                 .setVideoBitRate(762800)  
                                 .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
                                 .done();
     FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);         
     executor.createJob(builder).run(); // Run a one-pass encode