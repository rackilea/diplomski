for(int i=start;i<=n;i++){    
            if(n%i==0) {
                current.add(i);
                getFactorsHelper(n/i,i,current,result);
                current.remove(current.size()-1);
            }              
        }