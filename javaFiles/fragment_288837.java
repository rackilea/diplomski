donatePet(Pet p) {
    if (p instanceof Dog) {
       //if you are here, it means the Pet type passed to your method is of type 'Dog'
       //do whatever you want to do here
       //to cast Pet to Dog
       Dog g = (Dog) p;
       //call the methods relevant to 'g' type
       //add these instances to a list which will help you with listAvailablePets()
    }
}