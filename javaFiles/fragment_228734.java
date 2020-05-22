postalCode = in.nextInt();
while(postalCode < 6000 || postalCode > 6999) {
   System.out.println("Need a number between 6000 and 6999")

   //... revalidate that it is an integer

   postalCode = in.nextInt();
}