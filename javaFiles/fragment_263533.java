String quantityStr = request.getParameter("quantity");
int quantity = 0;  // replace with whatever default value you want

// only parse for non-null, non-empty inputs
if (quantityStr != null && quantityStr.length() > 0) {
    quantity = Integer.parseInt(quantityStr);
}