@RequestMapping("/approveRequestById")
public String approveRequestById(Principal principal, @RequestParam(value="id") String requestId, Model model, RedirectAttributes redirectAttributes) {

        //use this
        redirectAttributes.addFlashAttribute("requestFlag", true);

        //instead of
        model.addAttribute("requestFlag", true);

        return "redirect:/requests";
    }