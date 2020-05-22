public void propertyChange(PropertyChangeEvent pcevent){
    Object obj = pcevent.getNewValue() ;
    System.out.println(obj.getClass()) ;

    //Problem should not occur with this call.
    if (pcevent.getPropertyName().equals("font")){
       Font newFt = (Font)obj;

       lblMessage.setFont(newFt);
    }
}