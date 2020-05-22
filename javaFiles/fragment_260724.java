@RequestMapping(value = { "/overview" }, method = RequestMethod.GET)
    public ModelAndView overViewPage(HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This is default page!");
        model.setViewName("hello");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        User u = userService.getUser(userDetail.getUsername());
        request.getSession().setAttribute("userId", u.getId());

        return model;

    }