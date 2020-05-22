@RequestMapping(value = "/StatusLista")
    public @ResponseBody String teste(Status Status, 
                                        HttpSession httpSession, 
                                        HttpServletRequest req,
                                        HttpServletResponse res) throws IOException {
        Session sess = (Session) httpSession.getAttribute("hibSess");
        StatusDAO staDao = new StatusDAO(sess);
        List<Status> lista = staDao.findAll();

        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").setPrettyPrinting().create();
        String gListStatus = gson.toJson(lista);
        return gListStatus;
    }