@RequestMapping(value = "saveworkday", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("workdayaddform") WorkdayAddForm workdayaddform, 
                       BindingResult bindingResult,
                       final RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) { // validation errors
            Date workdayBegin = workdayaddform.getBeginDate();
            Date workdayEnd = workdayaddform.getEndDate();

            if (!UtilityClass.dateIsAfterDate(workdayBegin, workdayEnd)) {
                // Add the vehicle you want to send to the other method.
                redirectAttributes.addFlashAttribute("vehicle", vehicle);
           redirectAttributes.addFlashAttribute("binding", bindingResult);
                return "redirect:/addworkday";    
            }
        // More code.
        else {
           redirectAttributes.addFlashAttribute("vehicle", new Vehicle());
           return "redirect:/addworkday"; 
        }
    }