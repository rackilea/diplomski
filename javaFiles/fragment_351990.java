request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);

@RequestMapping(value = "/call1url", method = RequestMethod.POST)
    public String make(HttpServletRequest request) {

        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "forward:/main";

    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String make2(HttpServletRequest request) {

        return "dash";

    }