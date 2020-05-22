for(int i = 0; i < pieces.length; i++) {
        final int index = i;
        Runnable shuffle = new Runnable() {
            public void run() {
                playLevel(pieces[index]);
            }
        };
        handler.postDelayed(shuffle, (i+1)*3000);
}