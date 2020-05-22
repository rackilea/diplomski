new Thread() {
    public void run() {
        //Play movie on button click
        IMediaReader reader = ToolFactory.makeReader(movieName);
        IMediaViewer viewer = ToolFactory.makeViewer();
        reader.addListener(viewer);
        int i = 0;
        while(reader.readPacket() == null)
        {
            //Make sure video is playing
            i++;            
            System.out.println("Frame " + i);
        }
        //This should appear after video ends
        System.out.println("End of video");
    }
}.start();