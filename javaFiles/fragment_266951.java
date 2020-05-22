Map<String, String> sample = new LinkedHashMap<String, String>();

sample.put("ifi1", "video1");
sample.put("ifi2", "video2");
sample.put("ifi3", "video3");
sample.put("ifi4", "video4");
sample.put("ifi5", "video5");
sample.put("ifi6", "video6");
sample.put("ifi7", "video7");
sample.put("ifi8", "video8");
sample.put("ifi9", "video9");

for (String video : sample.values())
    System.out.println(video);

// Prints
video1
video2
video3
video4
video5
video6
video7
video8
video9