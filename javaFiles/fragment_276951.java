for(Map.Entry<String, Object> entry : map.entrySet()){
    for (Map.Entry<String, Object> entry2 : ((Map<String, Object>)(Object) entry.getValue()).entrySet()){
        sheet.addCell(new Label(c++, r+1, (String) entry2.getValue()));
    }

}