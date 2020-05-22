for (String string : loanIds) {  
        loanFinance = new LoanFinance();               
        loanFinance.setFundingBankId(bankId);
        loanFinance.setIdFundsProductPurpose(Long.valueOf(68449));
        loanFinance.setLoanId(Long.parseLong(string));
        loanFinance.setLastModifiedBy(user.getId());
        loanFinance.setIdEntityloan(Long.parseLong(string));
        loanFinance.setAmount(10000.00);
        loanFinance.setStatus("A"); 

        commonRepository.save(loanFinance);     
        System.out.println("Saved Datas");
    }