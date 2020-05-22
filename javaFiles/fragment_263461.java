try {

    final String rootPath = Environment.getExternalStorageDirectory().getPath() + "/Myapp/music/";
    String p1 = rootPath + "outputfiles/1.wav";
    Log.d("p1 " + p1); 
    File f1 = new File(p1);
    Log.d("f1 " + f1.exists() && !f1.isDirectory());  

    String p2 = rootPath + "outputfiles/com.wav";
    Log.d("p2 " + p2); 
    File f2 = new File(p2);
    Log.d("f2 " + f2.exists() && !f2.isDirectory());  

    Wave w1 = new Wave(p1);
    Log.d("w1 " + w1); 

    Wave w2 = new Wave(p2);
    Log.d("w2 " + w2); 

    FingerprintSimilarity fingerprintSimilarity = w1.getFingerprintSimilarity(w2);
    Log.d("fingerprintSimilarity " + fingerprintSimilarity ); 
    float score = fingerprintSimilarity.getScore();
    Log.d("score " + score ); 
    float similarity = fingerprintSimilarity.getSimilarity();
    Log.d("Similar sound :", "Score : " + score + "\n  Similarity : "+ similarity);
} catch (Exception e) {
    Log.d("Error" + e.getMessage()); 
}