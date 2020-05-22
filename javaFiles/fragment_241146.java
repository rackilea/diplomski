boolean isSet(int value, int bit){
   return (value&(1<<bit))!=0;
}  

int setBit(int value, int bit){
   return value|(1<<bit);
}