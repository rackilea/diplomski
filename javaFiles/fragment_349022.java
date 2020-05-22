public String execute(){  

        ActionContext ac=ActionContext.getContext();  
        ac.setLocale(getLocale());  
        return "success";  
    }