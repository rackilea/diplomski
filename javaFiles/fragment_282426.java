static void safeWithdraw(AtomicInteger account, int amount) {
    for(;;) {
        int current=account.get();
        if(amount>current) throw new IllegalStateException();
        if(account.compareAndSet(current, current-amount)) return;
    }
}