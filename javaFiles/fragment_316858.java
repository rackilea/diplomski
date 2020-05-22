public /* synchronized */ boolean transfer_funds(Account acc, int amount){ // dest : acc 
        if (enoughFund(amount)){
            withdraw(amount);  // <- thread can be preempted in the middle of method execution
            acc.deposit(amount);
            return true;
        }
        return false;
    }