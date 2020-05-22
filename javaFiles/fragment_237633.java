@OneToMany(mappedBy = "STATUS_ID")
private Set<User> Loan;
-----------------------------------
@ManyToOne
@JoinColumn(name = "STATUS_ID")
private LoanStatus loanStatus ;