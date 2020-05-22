for (int availPoints = 400; availPoints < 2000; availPoints += 200) {
        int rank = availPoints / 500;
        int pointsMax = (rank + 1) * 500;
        int MoneyMax = (rank + 1) * 25;
        System.out.printf("availPoints %d -> pointMax=%d MoneyMax=%d%n",
            availPoints, pointsMax, MoneyMax);
    }