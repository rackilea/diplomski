public String newlist(){
  StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i <= nbComposant;i++){
        sb.append(ref+i+" (quantity  "+quantity+i+")");
    }
   return sb.toString();
}
public String toString(){
    return newlist();
}