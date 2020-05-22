Collections.sort(mlistElectricity, new Comparator<RetailerPlanBean>(){
    @Override
    public int compare(RetailerPlanBean emp1, RetailerPlanBean emp2) {

        double emp2Price = Double.parseDouble(emp2.getmPRICE().replace("$",");
        double emp1Price = Double.parseDouble(emp1.getmPRICE().replace("$",");

        if (emp2Price == emp1Price )
            return 0;
        else if (emp1Price > emp2Price )
            return 1;
        else
            return -1;
    }
});