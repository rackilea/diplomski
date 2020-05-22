public static void main(String args[]){
    Metal m1 = new Iron(true);
    System.out.println("Should be Iron->"+ m1);
    System.out.println("Should be Enchanted (True)->" + m1.isEnchanted());
    Metal i1 = new Iron();
    System.out.println("Should not be Enchanted (False)->"+i1.isEnchanted());
}