try {
       Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.siren);

       player = MediaPlayer.create(this, uri);
       player.setLooping(true); // This will play sound in repeatable mode.
       player.start();

        } catch (Exception e) {
        e.printStackTrace();
    }