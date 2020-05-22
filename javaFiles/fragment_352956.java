public <T> JAXBElement<T> getJaxbElement (Object obj){
    Object ret;
    if (obj instanceof OrderType){
        ret = objectFactory.createOrderType((OrderType)obj);
    }
    else if (obj instanceof BookType){
        ret = objectFactory.createBookType((BookType)obj);
    }
    return (JAXBElement<T>) ret;
}