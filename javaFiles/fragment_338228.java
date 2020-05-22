@RequestMapping(value = "/customer", method = RequestMethod.POST)
   public String addCustomer(@ModelAttribute("customer") Customer customer,Model model)
{
    service.addCustomer(customer);
    model.addAttribute("custform",customer);
    return "customer/customer";
}