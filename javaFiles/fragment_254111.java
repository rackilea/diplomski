for(int i=0;i<l.size();i++){
    min=i;
    for(int j=i+1;j<l.size();j++){
        if((double)(l.get(j).get(0)) < (double)(l.get(min).get(0))){
            min=j;
        }
    }
    ArrayList temp=l.get(i);
    l.set(i, l.get(min));
    l.set(min, temp);       
}