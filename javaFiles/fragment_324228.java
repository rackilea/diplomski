public class TestBean {

    private boolean enablePolling;
    private StringBuffer buildOutputSb = new StringBuffer();

    public TestBean() {
    }

        public boolean isEnablePolling() {
        return enablePolling;
    }

    public void setEnablePolling(boolean enablePolling) {
        this.enablePolling = enablePolling;
    }

    public void startPolling(){
        this.enablePolling = true;
    }

    public void startBuild(){

        this.buildOutputSb= new StringBuffer();

        //Stimulating the build process , which will output the log message to the buildOutputSb
        for (int i=0 ; i <10 ; i++){
            buildOutputSb.append("Output").append(i).append("<br/>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
        this.enablePolling = false;
    }

}