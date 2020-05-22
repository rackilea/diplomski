public Contact search(String searchName) {

    for(Contact obj: al) {
        //I assume that searchName will never be null
        if(searchName.equals(obj.getNickName()) {
            return obj;
        }
    }
    return null;
}