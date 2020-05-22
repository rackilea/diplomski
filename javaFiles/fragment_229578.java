String page = request.getParameter("page"); 
    PagedListHolder<Product> products; 
    if ("previous".equals(page)) { 
        products = (PagedListHolder<Product>) request.getSession().getAttribute("pagedProductList"); 
        products.previousPage(); 
    } else if ("next".equals(page)) { 
        products = (PagedListHolder<Product>) request.getSession().getAttribute("pagedProductList"); 
        products.nextPage(); 
    } else { 
        products = new PagedListHolder<Product>(productDAO.searchByKeyword(keyword)); 
        products.setPageSize(10); 
        request.getSession().setAttribute("pagedProductList", products); 
    } 
    model.addAttribute("products", products);