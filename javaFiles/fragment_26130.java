double amount = 1; // make sure it initially equals 1

for (int daysWorked = 1; daysWorked <= numDaysWorked; daysWorked++) {

    System.out.println("Pay for day #" + daysWorked + ": " + formatter.format(amount));

    totalPay += amount; // add the amount value each time to the totalPay variable
    amount *= 2; // it doubles so just double it every loop
}

System.out.println("\nTOTAL PAY FOR " + numDaysWorked + " DAYS: " + formatter.format(totalPay));