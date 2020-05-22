public class MainThreads {
    public static void main(String[] args) {
        RequestThread rt = new RequestThread("sample");
        rt.start();

        //RequestThread another = new RequestThread("sample-2");
        //another.start();

        //RequestThread newThread = new RequestThread("sample-3");
        //newThread.start();
    }

    public static class RequestThread extends Thread {
        private final String request;
        // One important thing to note here, "service" has to be non-final. Else mockito won't be able to inject the mock.
        private MyDataWebServiceInterface service;

        public RequestThread(String request) {
            this.request = request;
            //1. Instantiate a service passing the required request parameter
            // => do it in constructor, or passed as parameter, but NOT in the function to test
            service = new MyDataWebService(request);
        }

        @Override
        public void run() {
            //2. Get the returned data
            List<String> dataList = service.requestData();

            //3. Write to file
            Path file = Paths.get("someDir/" + request);
            try {
                Files.write(file, dataList, Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}