int count1 = 0, count2=0;
       for (int i = 0; i < 10000; i++) { 
           float x = genFloat(null);
           if (x < 1E38 && x > 0) count1++;
           if (x > Float.MAX_VALUE - 1E38) count2++;
       }
       System.out.println(count1);
       System.out.println(count2);