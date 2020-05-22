@RequestMapping("/index")
    private String InitPage(Model map) {
        System.out.println("Entered index page");
        map.addAttribute("display", new Display());
        return "home";
    }