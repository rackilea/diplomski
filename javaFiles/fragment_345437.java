...
        while(l<=u)
        {
            mid=(int) ((l+u)/2);
            if(ns.compareTo(a[mid]) > 0)
            {
                l=mid+1;
            }
            else if(ns.compareTo(a[mid])<0)
            {
                u=mid-1;
            }
            else if(ns.compareTo(a[mid])==0)
            {
                f=1;
                break; //<- add this statement
            }
        }
...