@RequestMapping(value = '/x', method = RequestMethod.POST)
public @ResponseBody
Map<String, Object> createX(@Validated @RequestBody DTO dto, BindingResult errors) {
     // I want that entity here which I get from db repo in my validator
    System.out.println(
            RequestContextHolder.getRequestAttributes().getAttribute(
                    "XEntity",
                    RequestAttributes.SCOPE_REQUEST
            )
    ); // I get that from RequestContextHolder
}