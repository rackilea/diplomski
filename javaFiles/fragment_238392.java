String query = String.format("INSERT INTO OrderDetails(Productid,ProductName,Quantity,Price,Discount,Image) VALUES('%s','%s','%s','%s','%s','%s');",
        order.getProductid(),
        order.getProductName(),
        order.getQuantity(),
        order.getPrice(),
        order.getDiscount());