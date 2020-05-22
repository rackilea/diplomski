private <X> X genericGet(String property) {

}

public String getString(String property) { 
//... checks on property (String specific)...
Object obj = genericGet(property);
//... checks if obj is what is expected and if good return it
return obj; 
}

public Date getDate(String property) { 
//... checks on property (Date specific)...
Object obj = genericGet(property);
//... checks if obj is what is expected and if good return it
return obj
}