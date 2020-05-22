Map<String, JFrame> frames = new HashMap<String, JFrame>();
    JFrame frame = new JFrame();
    for (int i = 0; i < 5 ; i++) {
        frame = new JFrame();
        frames.put("Window" + i,frame);
    }