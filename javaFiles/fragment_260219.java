LoanAccountData loanAccountData1 = (LoanAccountData) o1;
LoanAccountData loanAccountData2 = (LoanAccountData) o2;
boolean o1Active = loanAccountData1.getStatusStringValue().equals("Active");
boolean o2Active = loanAccountData2.getStatusStringValue().equals("Active");
if (o1Active == o2Active) {
    return 0;
} else if (o1Active) {
    return -1;
} else {
    return 1;
}