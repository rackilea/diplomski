int list1[] = {1,1,1,1,1,1,1,1,1,1,1,1};
    int list2[] = {2,2,2,2,2,2,2,2};
    int list3[] = new int[100];
    int list4[] = {4,4,4,4,4,4,4,4};
    int list5[] = new int[100];
    int i=1,j,k=0,n=0,m=0;int h=0;
    while (k < list1.length+list2.length){      
        if (i++%5 !=0 && n<list1.length) {
            list3[k++]=list1[n++];
        }
        else  {
            if (n==list1.length && m<list2.length) {
                System.out.println("\nEnd of list1 and list2 even has " + m + " elements");
                i=1;j=1;n=0;
                int nl2=list2.length-m; //new length of list2
                while (h < list4.length+nl2){      
                    if (i++%5 !=0 && n<list4.length) {
                        list5[h++]=list4[n++];
                    }
                    else  {                
                        i=1;j=1;
                        while (j++%3 !=0 && m<list2.length) list5[h++]=list2[m++];                
                    }                                      
                }   
                break;
            }
            i=1;j=1;
            while (j++%3 !=0 && m<list2.length) list3[k++]=list2[m++];                
        }                                      
    }

    System.out.println("\nList 3:");
    for (i=0;i<k;i++)
        System.out.print(list3[i]+" ");  

    System.out.println("\n\nList 5:");
    for (i=0;i<h;i++) 
        System.out.print(list5[i]+" ");