public void getName(String number) {   
    for (String person : this.phonebook.keySet()) {   
        if (this.phonebook.get(person).contains(number)) {   
            System.out.println(" " + person);
            return;
        }    
    }
    System.out.println("  not found"); 
}