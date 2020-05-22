public class TfIdfMain
    public TfIdfMain(){
        for(String file : files) {
            DocumentParser dp = new DocumentParser();
            dp.parseFiles(file);
            dp.getCosineMatrix();
        }
    }
}