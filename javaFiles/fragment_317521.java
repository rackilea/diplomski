User user = userService.find(firstName, lastName);
if (user == null) {
    user = loanService.createUser(new User(firstName, lastName));
}
loan.setSum(sum);
loan.setUser(user);
loanService.save(loan);