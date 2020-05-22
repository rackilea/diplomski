if(a.length>0) {            
        int i=0,j=0; 
        do{
            j=i+1;
            while(j<a.length){
                if(a[j]-a[i]!=j-i)
                    break;
                j++;
            }
            if(i==j-1)
                System.out.println(a[i]);
            else
                System.out.println(a[i] + "-" + a[j-1]);
            i=j;
        }while(i<a.length);
    }