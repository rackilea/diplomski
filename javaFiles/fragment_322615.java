@SuppressWarnings("unchecked")
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String list(Model model) {
        List<String> tl = new ArrayList<String>();
        tl.add("one");
        tl.add("two");
        tl.add("three");
        model.addAttribute("testlist", tl);
        return "mainview";
    }