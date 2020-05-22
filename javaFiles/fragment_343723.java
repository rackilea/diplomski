@Override
        public int compare(HomeItemModel o1, HomeItemModel o2){
            //DESC order
            if(o1.getWeight() == o2.getWeight()){
                return 0;
            }else if(o1.getWeight() < o2.getWeight()){
                return 1;
            }else{
                return -1;
            }
        }