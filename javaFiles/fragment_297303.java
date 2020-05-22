@PostMapping(value = "/evaluate", produces = "application/json")
    public ResponseEntity<?> sendEvaluateForm(@RequestParam ("client") String client,
                                                               @RequestParam(value = "files", required = false) MultipartFile files) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Client clientobject = mapper.readValue(client, Client.class);

        return ResponseEntity.ok().build();
    }