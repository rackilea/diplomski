for (Workers worker : workers) {
        System.out.println("Week 1 pay period: " + worker.fullName());
        worker.calculateWeeklyPay(40);
        System.out.println("Week 2 pay period: ");
        worker.calculateWeeklyPay(50);
        System.out.println("Week 3 pay period: ");
        worker.calculateWeeklyPay(40);
}