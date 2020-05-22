AppModuleImpl appModule = (AppModuleImpl)(JSFUtils.getApplicationModule("AppModuleDataControl"));  
    ViewObject someTableVO =appModule.findViewObject("someTableView1");          


    Row row= someTableVO.createRow();  

    row.setAttribute("A", variable1);  
    row.setAttribute("B", variable2);  
    row.setAttribute("C", variable3);  
    row.setAttribute("D", variable4);  



    someTableVO.insertRow(row); 

    row.validate();     // This statement solved the problem

    appModule.getDBTransaction().commit();  

    someTableVO.executeQuery();