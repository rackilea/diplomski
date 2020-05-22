if (resultSet!= null) {
        while (resultSet.next()) { 
            Product product = new Product();
            product.setProductId(resultSet.getInt("productId"));
            product.setProductName(resultSet.getString("productName"));
            productList.add(product);
        }
        request.setAttribute("productList", productList);
        RequestDispatcher rd = request.getRequestDispatcher("adminViewSearch.jsp");
        rd.forward(request, response);
    }