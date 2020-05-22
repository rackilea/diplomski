subDzs = new ... // create a new instance
           for(String dz:DZs){
               subDzs.add(dz);
           }
           Participant sub=new Participant(lowerBound,upperBound);
           allSubs.add(sub);
           System.out.println("Map contains key? " +subToDz.containsKey(sub));
           subToDz.put(sub,subDzs);