private void cekNomor(String kata, i){
    final String[] noPanggil = kata.split("(?<=\\G.{1})");
    switch (noPanggil[i]){
        case "0":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.nol);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "1":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.satu);
                Log.e("SUARA", noPanggil[i]);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "2":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.dua);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "3":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.tiga);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "4":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.empat);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "5":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.lima);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "6":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.enam);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);;
                    }
                });
            }
            break;
        case "7":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.tujuh);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "8":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.delapan);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
        case "9":
            if(i==0){
                panggil = MediaPlayer.create(AntrianLoket.this, R.raw.sembilan);
            }else{
                panggil.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        cekNomor(String kata, ++i);
                    }
                });
            }
            break;
    }
    panggil.start();
}