@Override
public int getCount() {
    if(objects.size() < 6){
        return objects.size();
    }
    else{
        return 6;
    }
}