@RequestMapping(value="/typePlan/{id}", method = RequestMethod.GET)
    public String typePlan(@PathVariable("id") int id, Model m){
        Users_Access model = new Users_Access();
        m.addAttribute("type", model.getTypePlan(id));
        return "home";
    }
}