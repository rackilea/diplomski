public class MyClass {

   private int fileIndex = 0;
   private File[] files;

   public void convertAudio(View v) {
     final File pathanme = new File(Environment.getExternalStorageDirectory() + "/sdcard/test");
     this.files = pathanme.listFiles();
     fileIndex = 0;
     convertFile(files[fileIndex]);

  }

   private void convertFile(File f) {
      if (f.getName().endsWith(".mp4")) {
         String filename = f.getName().toLowerCase().toString();
         System.out.println(filename);

         File wavFile = new File(pathanme, filename);
         IConvertCallback callback = new IConvertCallback() {
            @Override
            public void onSuccess(File convertedFile) {
               Toast.makeText(NewMainActivity.this, "SUCCESS: " + convertedFile.getPath(), Toast.LENGTH_LONG).show();
               fileIndex++;
               if (this.files.size > fileIndex) {
                  convertFile(this.files[fileIndex];
               } else {
                  // we're done converting
               }
            }

            @Override
            public void onFailure(Exception error) {
               Toast.makeText(NewMainActivity.this, "ERROR: " + error.getMessage(), Toast.LENGTH_LONG).show();
               // cancel out or keep going, whatever
            }
         };

            Toast.makeText(this, "Converting audio file..." + filename, Toast.LENGTH_SHORT).show();

            AndroidAudioConverter.with(this)
                    .setFile(wavFile)
                    .setFormat(AudioFormat.MP3)
                    .setCallback(callback)
                    .convert();
        }
   }
}