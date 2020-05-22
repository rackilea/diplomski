Loans loans = new Loans(List.of(new Loan("A", 6), new Loan("B", 10), new Loan("C", 12));
loans.getUpTo(1); // <empty>
loans.getUpTo(5); // <empty>
loans.getUpTo(6); // Loan("A", 6)
loans.getUpTo(10); // Loan("A", 6), new Loan("B", 10)
loans.getUpTo(11); // Loan("A", 6), new Loan("B", 10)
loans.getUpTo(12); // Loan("A", 6), new Loan("B", 10), Loan("C", 12)
loans.getUpTo(100); // Loan("A", 6), new Loan("B", 10), Loan("C", 12)