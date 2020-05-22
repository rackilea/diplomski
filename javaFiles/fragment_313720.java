public Menu(){
    List<Option> options = new ArrayList<Option>();

    Option buyMore = new Option("Buy More");
    Option stealIt = new Option("Steal It");

    Option manageStock = new Option("Manage Stock", Arrays.asList(buyMore, stealIt));
    Option fireEmployee = new Option("Fire Employee");
    Option exit = new Option("Exit");

    Option selectStore = new Option("Select Store", Arrays.asList(manageStock, fireEmployee, exit));
    Option listStores = new Option("List Stores");
    Option exitStore = new Option("Exit");

    options.addAll(Arrays.asList(selectStore, listStores, exitStore));

    for(int i = 0; i < options.size(); ++i){
        options.get(i).print("", i + 1);
    }
}

class Option{
    String title;
    List<Option> subOptions;

    public Option(String title, List<Option> subOptions){
        this.title = title;
        this.subOptions = subOptions;
    }

    public Option(String title){
        this.title = title;
        this.subOptions = new ArrayList<Option>();
    }

    public void print(String indent, int number){
        System.out.println(indent + number + ". " + title);
        for(int i = 0; i < subOptions.size(); ++i){
            subOptions.get(i).print(indent + "  ", i+ 1);
        }
    }
}