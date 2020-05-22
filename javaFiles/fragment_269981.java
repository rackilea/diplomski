double totalCost = 0.0;
Food hamburger = new Food(....);
totalCost += hamburger.getCost(); // sum up the cost of hamburger

Food salad = new Food(...);
totalCost += salad.getCost();  // sum up the cost of salad

System.out.println("total cost" + totalCost);