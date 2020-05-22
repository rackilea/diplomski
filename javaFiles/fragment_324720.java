List<Object> play1List = Arrays.asList(play1);
    for (int i =0 ; i< pre.length;i++){
        List<Object> preList = Arrays.asList(pre[i]);
        if(preList.equals(play1List)){
            System.out.println("FounD"+preList);
            break;
        }    
    }