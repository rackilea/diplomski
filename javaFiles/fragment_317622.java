Student student1;
if(inputSelection==1){
    int inputDurationWeek= checkInputInteger("Enter the number of week stay:");
    double inputWeeklyExpenses = checkInputDouble("Enter weekly expeneses");
    double inputCostRoom =checkInputDouble("Enter the cost of the room or board per week");
    student1 = new DormStudent(inputName,inputYear,inputSuppliesCost,inputCreditHour,inputHourPrice,inputDurationWeek,inputWeeklyExpenses,inputCostRoom);
    student1.printTotalCost();
}else{
    student1 = new Student(inputName, inputYear, inputSuppliesCost,inputCreditHour, inputHourPrice);
    student1.printTotalCost(); // do you really need to print it twice?
}
student1.printTotalCost();