<%

String[] favouriteCars = request.getParameterValues("favouritecar");
   for (int i = 0; i < favouriteCars .length; i++) {
      String car = favouriteCars [i];
      System.out.println("car name::"+car);

%>