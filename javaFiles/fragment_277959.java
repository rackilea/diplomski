for(Element selectField:allSelections){
                String nameField = selectField.attr("name");
                String valueField = "";
                Elements allOptions = selectField.getElementsByTag("option");
                for(Element opt:allOptions){
                    if(opt.attr("selected").equalsIgnoreCase("selected")){
                        valueField = opt.attr("value");
                        break;
                    }
                }
                postData.put(nameField, valueField);                    
            }

            for(Element inputField:allInputFields){
                if(inputField.attr("type").equalsIgnoreCase("checkbox")){
                    postData.put(inputField.attr("name"), inputField.attr("checked").equalsIgnoreCase("checked")?"1":"0");
                }else{
postData.put(inputField.attr("name"), inputField.attr("value"));
    }