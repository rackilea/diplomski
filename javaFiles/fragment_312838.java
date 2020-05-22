public boolean checkPresence(int rank){
for(int i=0;i<hand.size();i++){
//note you will need to implement getters to the Card class first
if (hand.get(i).getRank==rank)
return true;
}
 return false;
}