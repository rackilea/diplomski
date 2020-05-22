public int compareTo(customText o){
    if(url.compareTo(o.ip)==0){
        return (ip.compareTo(o.ip));
    }
    else return (url.compareTo(o.ip));
}