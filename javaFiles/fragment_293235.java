public static void main(String[] args) {


   // String model = "07:40,09:00,10:20,11:40,|08:00,09:00,|";
    String model = "";
    String[][] model1 = getModel(model);
          if (model1!=null) {
        for (String[] model11 : model1) {
              for (String model111 : model11) {
                  System.out.print(model111+" ");
              }
              System.out.println("");

    }
    }

}