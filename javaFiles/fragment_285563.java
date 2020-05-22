System.out.println("Item Title:");
title = scan.nextLine();
boolean found = false;
for (MediaItem mi : media){ 
    if (mi.getTitle().equals(title) && mi.onLoan == true){
        found = true;
        System.out.println("Already Loaned");
        break;
    }
}
if (!found) {
    System.out.println("no entry");
}