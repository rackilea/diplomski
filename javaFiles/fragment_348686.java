for (int i = 0; i < InputOrder.size(); i++) {
    ProdRefCode = InputOrder.get(i).getProdRefCode();
    ProdModelNo = InputOrder.get(i).getProdRefCode(); // same as above ?
    ProdCost = InputOrder.get(i).getProdCost();
    updatedQuantity =Integer.valueOf(request.getParameter("ddlQuantity" + i));

    // Create a list that holds one quantity value
    List<Integer> quantity = Arrays.asList(updatedQuantity);
    Cart updateCart = new Cart(ProdRefCode, ProdModelNo, ProdCost, quantity);
    OutputOrder.add(updateCart);

    listCount = OutputOrder.size(); // ?
}