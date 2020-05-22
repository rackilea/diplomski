case 2: {
    System.out.println("Enter the contact name you want to edit");
    temp=s.next();
    int z=name.indexOf(capitalize(temp));
    if(z!=-1)
    {
        System.out.println("Edit to?");
        temp=s.next();
        name.set(z, capitalize(temp));
        System.out.println("Name edited to "+capitalize(temp));
    }
    else
        System.out.println("Name not found");
    break;
}