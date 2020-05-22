public static void main(String[] args) {
    List <Payroll> employes = new ArrayList<>();

    employes.add( new Payroll("Tiny Tim", 100.2534, 40.87876));
    employes.add( new Payroll("Brad Pitt", 150.50, 10));
    employes.add( new Payroll("Madonna", 124.24, 20));

    for(Payroll p :employes){
    System.out.println(p.toString()+"\n");
    }
}