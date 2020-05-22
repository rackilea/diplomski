public int getCost()
{ 
    if(this.get("cost")==null)
     return -1;
    return Integer.parseInt(super.get("cost"));
}