@RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String newClient(ModelMap model){
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("edit", false);
        return "registration";

    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "registration";
        }


        clientService.saveClient(client);
        model.addAttribute("success", "Client" + client.getNomeClient() + "registrato correttamente");

        return "success";

    }