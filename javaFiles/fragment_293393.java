if (!subDzs.isEmpty()){
               subDzs.clear();
           }
           for(String dz:DZs){
               subDzs.add(dz);
           }
           Participant sub=new Participant(lowerBound,upperBound);
           allSubs.add(sub);
           System.out.println("Map contains key? " +subToDz.containsKey(sub));//returns false
           subToDz.put(sub,subDzs);//overwrites existing values everytime new key,value is put