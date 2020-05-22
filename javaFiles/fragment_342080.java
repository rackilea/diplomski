@RequestMapping(value = "businessBill.htm", method = RequestMethod.POST)
@ResponseBody
public String handleBusinessBillDetails(@RequestParam("reference") String billReference, @RequestParam("invoiceDate") String billDate, 
            HttpServletRequest request, HttpServletResponse response) {

    String json = null;        

    try {

        //1. Create 'jackson' object mapper
        ObjectMapper objectMapper = new ObjectMapper();  

        BusinessBillDTO businessBillDTO = new BusinessBillDTO();
        businessBillDTO.setBillDate(sdf.parse(billDate));
        businessBillDTO.setBillReference(billReference);

        BusinessBillDTO billDto = accountStatementBO.getBusinessBillDetails(businessBillDTO);

        //2. Convert your 'bean' or 'dto' as 'json' string
        json = objectMapper.writeValueAsString(billDto);            

    } catch (Exception ex) {
        LOGGER.error(ex);
    }
    return json;
}