mFileFont = new File("/system/fonts/Roboto-Regular.ttf");
        if (!mFileFont.exists())
            mFileFont = new File("/system/fonts/DroidSerif-Regular.ttf");
   String[] cmd = new String[]{
                "-i", savedVideoFilePath, "-vf", "drawtext=text=" + "'" + todaysdate
                + "'" + ": fontfile=" + mFileFont.getAbsolutePath() + ": 
               fontcolor=white: fontsize=24: x=20: y=50: box=0:", "-codec:a", "copy", 
              "-preset", "ultrafast", "-b:a", "128k", output_path};