@RequestMapping(value = "/Controller/getVehicleDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, , consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<AjaxResponse> controller(@RequestBody Vehicle vehicle) {
        //vehicle.getEngine().getEngineId()
        return new ResponseEntity<AjaxResponse>(new AjaxResponse("Success"), HttpStatus.OK);
    }