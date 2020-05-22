class Task implements Callable<String> {

    private RestTemplate restTemplate;

    public Task(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String call() throws Exception {

        String url = "some_url";
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}