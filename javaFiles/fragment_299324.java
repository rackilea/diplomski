function selectedValue(){  

    var value =<%=request.getParameter("selectedValue")%>;  
    if(value !=null)  
        {

        document.f1.slvalue.selectedIndex=value ;          

        }    

}