@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity requestTEST(HttpServletRequest request, HttpServletResponse response) {

//        HttpGet httpGet = new HttpGet("http://www.webservicex.net/country.asmx/GetCountries"); // xml output format
        HttpGet httpGet = new HttpGet("http://services.groupkt.com/country/get/all");//json output format
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse res = null;
        StringBuilder resEntity = null;

        try {

            res = httpClient.execute(httpGet);
            resEntity = new StringBuilder();
            BufferedReader bf = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            List<String> lines = IOUtils.readLines(bf);
            for (String line : lines) {
                resEntity.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        for (Header h : res.getAllHeaders()) {
            headers.add(h.getName(), h.getValue());
        }

        return new ResponseEntity(resEntity, headers, HttpStatus.valueOf(res.getStatusLine().getStatusCode()));
    }