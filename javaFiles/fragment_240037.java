System.out.println("What item are you looking for?");

nameOfItem = keyboard.nextLine();

boolean found = false;


for (Item item : cart1) {
    if (item.getName().equals(nameOfItem)) {
        found = true;
    }
}

if (found) {
   System.out.println("You do have that item in your cart!");
} else {
    System.out.println("You do not have that item in your cart, press\n2 on the "
                        + "next screen to add it to your cart");
}