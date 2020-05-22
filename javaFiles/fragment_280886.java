public static void main(String[] args) throws Exception{        
        long totalTimeMS = 0;

        for (int i = 0; i < 10; i++) {

        long startTime = System.currentTimeMillis();


        HttpGet get = new HttpGet("http://stackoverflow.com");
        HttpClient client = new DefaultHttpClient();
        client.execute(get);       

        long endTime = System.currentTimeMillis();
        long duration = (endTime-startTime);
        totalTimeMS +=duration;
        System.out.format("Duration %d ms\n", duration);
        }

        System.out.format("Average time is %d ms", (totalTimeMS/10));
    }