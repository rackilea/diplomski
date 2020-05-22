clip.addLineListener( new LineListener() 
        {
            public void update(LineEvent event) 
            {
                if (event.getType() == LineEvent.Type.STOP) 
                {
                    event.getLine().close();
                    System.exit(0); // <------------ terminate the JVM
                }
            }
        });