@GetMapping(value = "your path")
    public ResponseEntity<HeaderDataDTO> getBuildDetails(@RequestHeader(value = "Custmer-Key") String custmerKey,@RequestHeader(value = "Customer-Key") String customerKey
            ) {
        HeaderDataDTO data = new HeaderDataDTO();
data.setCustomerKey(customerKey);
data.setCustmerKey(custmerKey);
data.validate();
        return new ResponseEntity<>(data,
                HttpStatus.OK);
    }