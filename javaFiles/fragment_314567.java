public void setId(int id) {
      this.id = id;
    }

    public void setBalance(double balance) {
      this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
      this.annualInterestRate = annualInterestRate;
      this.balance = balance * annualInterestRate;
    }