@RequestMapping(value="",method=RequestMethod.Method)
    public myMethod(HttpServletResponse response) throws IOException
    {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename);
        response.setContentType("application/XXX");         
    }