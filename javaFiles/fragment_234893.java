.type("Vehicle", typeWriting ->
                    typeWriting
                            .typeResolver(t)
            )


    @PostMapping("getVehicle")
    public ResponseEntity<Object> getVehicleMaxSpeed(@RequestBody String query) 
   {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }