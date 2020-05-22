@RequestMapping(value = "download", method = RequestMethod.GET)
    public void download(Locale locale, Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
        response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment; filename=evaluations.csv");

        try
        {
            OutputStream outputStream = response.getOutputStream();
            String outputResult = "xxxx, yyyy, zzzz, aaaa, bbbb, ccccc, dddd, eeee, ffff, gggg\n";
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch(Exception e) {

           //logging
        }
    }