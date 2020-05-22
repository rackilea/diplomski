Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
Format input2 = new AudioFormat(AudioFormat.MPEG);
Format output = new AudioFormat(AudioFormat.LINEAR);
PlugInManager.addPlugIn(
        "com.sun.media.codec.audio.mp3.JavaDecoder",
        new Format[]{input1, input2},
        new Format[]{output},
        PlugInManager.CODEC);