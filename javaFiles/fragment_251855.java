String products[] = request.getParameterValues("products"); 
     if (products!= null && items!= null && products.length != 0 && items.length != 0) {
            for (int i = 0; i < products.length; i++) {
     //your code
   <div class="form-group">
    <label for="product_name">Product Total Price: <%
    //getting item value of that selected checkbox 
  int item_no=Integer.parseInt(request.getParameter("item_no_" + products[i]));
  int propri=Integer.parseInt(rs.getString("product_price"));
  out.println(num1 * propri); int gtotal= num1 * propri;   %></label>
      <input type="hidden" class="form-control" id="item_no" name="item_no" value='items[j]'>
</div>