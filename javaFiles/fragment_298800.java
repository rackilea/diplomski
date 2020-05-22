@RequestMapping(value = "/downloadCSV", method = RequestMethod.POST)
    public void getCSV(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException{

        System.out.println("DEBUT TELECHARGEMENT");
        // SOME LOGIC
        System.out.println("FIN TELECHARGEMENT");

    }