public static void merge(ArrayList <Comparable> a, int first, int mid, int last){
            ArrayList <Comparable> vectorFirst = new ArrayList<Comparable>();
            ArrayList <Comparable> vectorSecond = new ArrayList<Comparable>();

            for(int k=first;k<=mid;k++){
                vectorFirst.add(a.get(k));
            }
            for(int k=mid+1;k<=last;k++){
                vectorSecond.add(a.get(k));
            }

            int i=first;
            int j=mid+1;
            int k=first-1;
            while((i<=mid)&(j<=last)){
                if(vectorFirst.get(i-first).compareTo(vectorSecond.get(j-mid-1))==-1){
                    k=k+1;
                    a.set(k,vectorFirst.get(i-first));
                    i=i+1;
                }
                else{
                     k=k+1;
                     a.set(k,vectorSecond.get(j-mid-1));
                     j=j+1;
                }
            }
            if(i==mid+1){
                while(j<=last){
                    k=k+1;
                    a.set(k,vectorSecond.get(j-mid-1));
                    j=j+1;
                }
            }
            else{
                while(i<=mid){
                    k=k+1;
                    a.set(k,vectorFirst.get(i-first));
                    i=i+1;
                }
            }


        }