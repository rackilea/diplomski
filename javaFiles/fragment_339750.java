@PostMapping("/saveTransaction")
    public String saveTransaction(@Valid Transactions transaction, BindingResult bindingResult) {
        validator.validate(transaction, bindingResult);
        if(bindingResult.hasErrors()) {
            System.out.println("Non formated form stuff.");
            return "transactions/transactionsForm";
        }