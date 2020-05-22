public static  <T extends Element>  List<T> getAllElements(Class<T> clazz) {
    List<WebElement> elements = getDriver().findElements(by);
    List<T> customElements = new ArrayList<>();

    for(int i=0; i<elements.size();i++){
        T element = null;
        try{
            element = clazz.getConstructor( new Class[]{String.class} ).newInstance( By.xpath("("+getXpath(by)+")["+i+1+"]") );     
        }catch(Exception e){
            //log or handle reflection related exceptions
        }
        customElements.add(element);
    }
    return customElements;
 }