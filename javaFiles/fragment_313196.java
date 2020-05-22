ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "--one-instance", videoInfos.filePath1);

ProcessBuilder pb1 = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", "--one-instance", videoInfos.filePath2);

pb.start();
Thread.sleep(4000);
pb1.start();