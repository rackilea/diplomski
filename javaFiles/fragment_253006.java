String price = request.getParameter("price").toString();
String errorMessage = "";

if(price != null && price != ""){
    try{
        intPrice = Integer.parseInt(price);
        if(intPrice  > 0){
            System.out.println("Price " + intPrice + " is greater to 0.");
        }else{
            System.out.println("Price " + intPrice + " is less then or equal to 0.");
        }
    }catch(Exception ex){
        ex.getMessage();
        errorMessage = "Price is not a Number.";
        response.sendRedirect("../insertproducts.jsp?insertproduct="+producttype+"&err="+errorMessage);
    }
}else{
   errorMessage = "Price was not given.";
   response.sendRedirect("../insertproducts.jsp?insertproduct="+producttype+"&err="+errorMessage);
}