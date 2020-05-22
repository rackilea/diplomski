@RequestMapping(value = "obj/save", method = RequestMethod.POST)
    public String insertObject(HttpServletRequest request, Model model) {
        NameObject obj= new NameObject();
        obj.setId(UUID.randomUUID());
        objService.saveUser(obj);  //@Autowried
        return "obj/saveok";
    }