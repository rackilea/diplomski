public boolean put(Element element) {
    // Ihr Code
    if(len >= SIZE) {
        return false;
    }else {
        data[len]=element;
        Element temp;
        for(int i=len; i>0; i--) {
            if(data[i].getPriority()>data[i-1].getPriority()) {
                temp=data[i];
                data[i]=data[i-1];
                data[i-1]=temp;
                i++;
            }
        }
        len++;
        return true;
    }
}