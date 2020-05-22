@RequestMapping(value="/someURL", method=GET)
public String yourMethod(RedirectAttributes redirectAttributes)
{
   ...
   redirectAttributes.addAttribute("rd", "rdValue");
   redirectAttributes.addFlashAttribute("fa", faValue);
   return "redirect:/someOtherURL";
}