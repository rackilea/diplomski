for (Element node : method.getChildren("Field")){ 
        if(node.getAttributeValue("Name").equalsIgnoreCase("Title")){
            node.setText("String");
        }
        System.out.println(node.getAttribute("Name").getValue());
    }