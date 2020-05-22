@GetMapping("/stream1")
        @ResponseBody
        public StreamingResponseBody getVidoeStream1(@RequestParam String any) throws IOException {
            /* do security check before connecting to stream hosting server */ 
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Resource> responseEntity = restTemplate.exchange( "http://localhost:8080/stream", HttpMethod.GET, null, Resource.class );
            InputStream st = responseEntity.getBody().getInputStream();
            return (os) -> {
                readAndWrite(st, os);
            };


    }

private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }