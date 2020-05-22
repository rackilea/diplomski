public String[] getParameterValues(String name) {  
    String[] result = null;  
    String[] temp = (String[]) parameters.get(name);  
    if (temp != null){  
        result = new String[temp.length];  
        System.arraycopy(temp, 0, result, 0, temp.length);  
    } else {
        return super.getParameterValues(name);
    } 
    return result;  
}