class Main {
  public static void main(String[] args) {
    Breakfast recipes = new Breakfast();
    recipes.frenchToast();
    System.out.println(recipes.frenchToast2());
  }
}

class Breakfast {
  public void frenchToast(){
    StringBuilder sba = new StringBuilder("For French toast you will need:\n ");
    sba.append("Eggs\n ");
    sba.append("Bread\n ");
    sba.append("Cinnamon\n ");
    sba.append("Vanilla ");
    System.out.println(sba.toString());
  }

  public static String frenchToast2(){
    StringBuilder sba = new StringBuilder("For French toast you will need:\n ");
    sba.append("Eggs\n ");
    sba.append("Bread\n ");
    sba.append("Cinnamon\n ");
    sba.append("Vanilla ");
    return(sba.toString());
  }
}