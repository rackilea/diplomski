public class SkanerActivity extends Activity {{

//your  present code

    protected void onCreate(Bundle savedInstanceState) {
     //your present code
     fileList = getfile(root);
      ImagesProcessorClass  imageProcessor = new ImagesProcessorClass (fileList);
       imageProcessor.processsImages();
     }


}