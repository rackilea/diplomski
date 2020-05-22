try {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.fretebras.com.br/fretes"));
        startActivity(i);
    } catch (ActivityNotFoundException e) {
        e.printStackTrace();
    }