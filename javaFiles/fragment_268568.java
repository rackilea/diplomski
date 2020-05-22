public doPost(HttpServletRequest req, HttpServletResponse res){
        int operation = Integer.valueOf(req.getParameter("opr"));

        if (operation == 1){
            registerCustomer(req);
        }else if (operation == 2){
            loginCustomer(req);
        }else if (operation == 3){
            SomeOtherMethod();
        }...
    }