// Create the directory
    File dir = new File(Environment
            .getExternalStorageDirectory() + "/.CSOUNDS/");
    // If it does not exists, make it.
    if (!dir.exists()) {
        dir.mkdir(); // Generating the directory
    }
    try {
        // Open the resource
        byte[] buffer = new byte[ins.available()];
        ins.read(buffer);
        ins.close();
        // Burn
        String filename = Environment
                .getExternalStorageDirectory().toString()
                + "/.CSOUNDS/"+song+".mp3";
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(buffer);
        fos.close();
    } catch (Exception e) {
    }
}

public void share(String song, InputStream ins){
    makeOutSide(song,ins);
    String rout = Environment.getExternalStorageDirectory().toString()+"/.CSOUNDS/"+song+".mp3";
    Uri uri = Uri.parse(rout);
    Intent share = new Intent(Intent.ACTION_SEND);
    share.setType("audio/*");
    share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    share.putExtra(Intent.EXTRA_STREAM,uri);
    startActivity(Intent.createChooser(share, "Share song"));
}