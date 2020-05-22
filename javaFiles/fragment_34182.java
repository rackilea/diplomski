@RequestMapping (value="/guessLetter", method=RequestMethod.POST)  
        public ModelAndView guessLetter (HttpServletRequest request, HttpServletResponse response, 
                @ModelAttribute("game") Game game, @RequestParam("guess") String guess,
                SessionStatus status, ModelMap model, BindingResult result) {
            System.out.println(guess);

            this.letterValidator.validate(game, result);

            if (result.hasErrors()) {
                return new ModelAndView("/views/index.jsp");
            }    

            request.getSession().setAttribute("game", game);        
            game.guessLetter(guess);        

            System.out.println(game.getGuessList());

            ModelAndView mav = new ModelAndView("redirect:index.htm");

            mav.addObject("game", game);
            model.addAttribute("game", game);
            return mav;
        }