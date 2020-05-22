Client client = ClientBuilder.newClient();
//2 is to increase amount of data and 3(seconds) is for time b/w chunked output  ,can be changed
        final Response response = client.target("http://jerseyexample-ravikant.rhcloud.com/rest/jws/streaming/2/3").request()
                .get();
        final ChunkedInput<String> chunkedInput = response.readEntity(new GenericType<ChunkedInput<String>>() {
        });
        chunkedInput.setParser(ChunkedInput.createParser(BOUNDARY));
        String chunk;
        while ((chunk = chunkedInput.read()) != null) {
            System.err.println("Next chunk received: " );
            System.out.println(chunk);
        }