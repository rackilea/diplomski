@RequestMapping(value = "/customer", method = RequestMethod.POST)
   public String addCustomer(@ModelAttribute("customer") Customer customer,Model model)
{
    service.addCustomer(customer);
    model.addAttribute("custid",customer.getCustId());
    model.addAttribute("name", customer.getName());
    model.addAttribute("age", customer.getAge());
    return "customer/customer";
}