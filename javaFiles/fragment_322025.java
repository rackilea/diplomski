@Autowired
ServiceInterface service;

    @RequestMapping(value = "example.html", method = RequestMethod.GET)
    public String viewUsers(Model model){       
    model.addAttribute("usersId", service.findAllIdForUsers());
    return "example";
    }