@RequestMapping(value = "processing", method = RequestMethod.GET)
public @ResponseBody ProcessResponse processData(@RequestParam("workflow") final String workflow,
    @RequestParam("conf") final String value, @RequestParam("dc") final String dc, HttpServletRequest request) {

        System.out.println(workflow);
        System.out.println(value);
        System.out.println(dc);
        System.out.println(request.getRemoteAddr());
        // some other code
    }