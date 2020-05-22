@RequestMapping(value="/Customer/{id}/Delete", method = RequestMethod.GET)
public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
  boolean isSuccess = DAO_Customer.deleteCustomer(id);
  if (!isSuccess) {
    redirectAttributes.addAttribute("error", "Failed");
  } else{ //also required
    redirectAttributes.addAttribute("success", "Successed");
  }
  return "redirect:/CustomerList";
}