public static void modifyPerformanceScale(TreeMap<Integer, Employee> idNumber, TreeMap<Employee, Integer> performanceScale) {
    System.out.print("Enter ID: ");
    Scanner keyboardInput = new Scanner(System.in);

    int idNumber1;
    int modScale;
    idNumber1 = keyboardInput.nextInt();

    System.out.print("Enter the number you want to change to: ");
    modScale = keyboardInput.nextInt();

    Employee employee = idNumber.get(idNumber1); //note: This will return null if the employee does not exist. Check for this, if necessary.
    performanceScale.put(employee, modScale);
}