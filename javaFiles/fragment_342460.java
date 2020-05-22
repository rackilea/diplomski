RestTemplate restTemplate = new RestTemplate();
restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());    
HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
HttpEntity<String> entity = new HttpEntity<String>(headers);

ResponseEntity<byte[]> response = restTemplate.exchange(URI, HttpMethod.GET, entity, byte[].class, "1");

if(response.getStatusCode().equals(HttpStatus.OK))
        {       
                FileOutputStream output = new FileOutputStream(new File("filename.jar"));
                IOUtils.write(response.getBody(), output);

        }