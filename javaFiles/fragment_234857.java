Iterator<int[]> expenses = val1.values().iterator();
    Iterator<Integer> people = val2.values().iterator();

    assert val1.size() == val2.size() : " size mismatch";
    while (expenses.hasNext()) {
        int[] expensesPerMonth = expenses.next();
        int persons = people.next();

        // do strange calculation
        int strangeSum = 0;
        for (int idx = 0; idx < expensesPerMonth.length; idx++) {
            strangeSum += persons * expensesPerMonth[idx];
        }
        System.out.println("strange sum :" + strangeSum);
    }