@RequestMapping(value = "/Controller/getVehicleDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<AjaxResponse> controller(@RequestParam(value = "engineId") Long engineId) {
        //Do whatever you want with the engineId
        return new ResponseEntity<AjaxResponse>(new AjaxResponse("Success"), HttpStatus.OK);
    }