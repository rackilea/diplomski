@RequestMapping(value = "/v1/virtualserver/" + MODULE_NAME + "/{id}/tdmCapture/{cardId}/chainUnchainE1T1/{interfaceId}",
    method = RequestMethod.PUT)
public @ResponseBody
 Object chainUnchainE1T1 (HttpSession session,  @PathVariable int id, @PathVariable int cardId, @PathVariable int interfaceId
    , @RequestBody Chained obj,HttpServletResponse response) {
tdmCaptureServiceInterface.chainUnchainE1T1(cardId, interfaceId, obj.chained);
return ResponseHandler.sendSuccessResponse(SAVE_SUCCESS, response);