Vector <? extends Updateable> 


public static int updateRates(Vector<? extends Updateable>  v) {
int sum = 0;
for (int i = 0; i < v.size(); i++) {
    if (v.get(i).isUpdated()){
        sum++;
    }
}
return sum;
}