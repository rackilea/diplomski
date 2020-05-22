List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(0,0,0,0,0,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4));  
        int last=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=last){
                last=list.get(i);
                list.add(i, -1);
                ++i;
            }
        }