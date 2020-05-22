@Test
public void testLoan() {
    User user = loanService.createUser(newUser());

    Loan loan1 = new Loan();
    loan1.setSum(10L);
    loan1.setUser(user);

    Loan loan2 = loanService.createLoan(loan1);
    assertNotNull(loan2);

    Integer loanId = loan2.getId();

    assertNotNull(loanId);
    assertEquals(loan1.getSum(), loan2.getSum());
    assertEquals(loan1.getUser(), user);

    User user2 = loanService.createUser(newUser());
    loan2.setUser(user2);
    loan2.setSum(20L);
    Loan loan3 = loanService.saveLoan(loan2);
    assertLoanEquals(loan2, loan3);

    Long total = loanService.incrementLoan(loanId, 10L);
    assertNotNull(total);
    assertEquals((Long)(loan3.getSum() + 10L), total);

    loan3.setSum(total);

    Loan loan4 = loanService.findLoan(loanId);
    assertLoanEquals(loan3, loan4);

    boolean result = loanService.deleteLoan(loanId);
    assertTrue(result);

    Loan loan5 = loanService.findLoan(loanId);
    assertNull(loan5);

    Long[] totals = new Long[]{1L,2L,3L};
    LoanRequest loanRequest = new LoanRequest();
    loanRequest.setFirstName("Amerigo");
    loanRequest.setLastName("Vespucci");
    loanRequest.setTotals(totals);

    List<Loan> loans = loanService.requestLoans(loanRequest);
    assertNotNull(loans);
    assertEquals(3, loans.size());
    for (int i = 0; i < 3; i++) {
        assertEquals(totals[i], loans.get(i).getSum());
        loanService.deleteLoan(loans.get(i).getId());
    }


}

void assertLoanEquals(Loan loan1, Loan loan2) {
    assertNotNull(loan1);
    assertNotNull(loan2);
    assertEquals(loan1.getSum(), loan2.getSum());
    assertUserEquals(loan1.getUser(), loan2.getUser());
    assertEquals(loan1.getId(), loan2.getId());
}
void assertUserEquals(User user, User user2) {
    assertNotNull(user);
    assertNotNull(user2);
    assertEquals(user.getId(), user2.getId());
    assertEquals(user.getFirstName(), user2.getFirstName());
    assertEquals(user.getLastName(), user2.getLastName());
}