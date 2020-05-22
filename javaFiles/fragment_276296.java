boolean isPresent = false;
for(String elem: list){
    if(elem.contains("xyz")){//check each string if it contains the element
        isPresent = true;
        break;
    }
}
if(!isPresent){
    throw new NoSuchElementException("Element wasn't found in the list");
}