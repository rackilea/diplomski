public static class Employee {
}

public static class Secretary extends Employee{
     public void work() {
     }
}

public static void main(String[] args) {
     Employee secretary = new Secretary();
     ((Secretary)secretary).work(); 
}