if(productList.size() == 0 ){
         request.setAttribute("message", "Search Failed"):        
    }else{
          request.setAttribute("productList", productList);             
    }

    RequestDispatcher rd = request.getRequestDispatcher("adminViewSearch.jsp");
    rd.forward(request, response);