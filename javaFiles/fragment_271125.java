@RequestMapping(value = "/addinvoice/{contractorId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public String addInvoice(@PathVariable("contractorId") String contractorId, @ModelAttribute @Valid InvoiceData data, BindingResult result, Model model , RedirectAttributes attr, HttpSession session) {
    if (result.hasErrors()) {
        System.out.println("BINDING RESULT ERROR");
        attr.addFlashAttribute("org.springframework.validation.BindingResult.data", result);
        attr.addFlashAttribute("register", result);
        return "redirect:/add";
    } else {
        Contractor contractor = contractorRepository.findById(contractorId).get();
        data.setData(contractor.getContractorData());
        if (contractor.getInvoices() == null) {
            contractor.setInvoices(new ArrayList<InvoiceData>());
        }
        contractor.getInvoices().add(data);
        invoiceDataRepository.save(data);
        contractorRepository.save(contractor);
        model.addAttribute("contractor", contractor);
        return "index";
    }
}