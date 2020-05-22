public int hashCode(){
    if(!hashed){
        StringBuilder s = new StringBuilder(
                  new StringBuilder(blockID).append(":").append(threadID).toString());
        hash = s.toString().hashCode();
        hashed= true;
    }

    return hash;
}