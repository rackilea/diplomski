static ArrayList<int[]> parts = new ArrayList<int[]>();
 static ArrayList<ArrayList<Integer>> atleast = new ArrayList<ArrayList<Integer>>();
 static ArrayList<Integer> maxi = new ArrayList<Integer>();
 static int stick[];
 static int base;
 static long num = 0;

 public static void makeParts(int min, int ptr)
 {
      int me = 0;
      do {
            array[ptr] = me;
            if (ptr > 0) makeParts(Math.max(me,min), ptr-1);
            else {
                 // add part
                 int[] newa = new int [array.length];
                 int i,mi,ma,last=array.length-1;
                 for (i=0 ; i<array.length ; i++) newa[i] = array[i];
                 parts.add(newa);
                 // maxi
                 for (i=0 ; i<=last && newa[i]==0 ; i++) /* */;
                 maxi.add(ma = i<=last ? newa[i] : 0);
                 // mini
                 for (i=last ; i>=0 && newa[i]==0 ; i--) /* */;
                 mi = i>=0 ? newa[i] : 0;
                 // add to atleast lists
                 int pi = parts.size() - 1;
                 ArrayList<Integer> l;
                 int imi = mi == 0 ? base-1 : mi;
                 for (i=0 ; i<=imi ; i++) {
                      if (i < atleast.size()) l = atleast.get(i);
                      else {
                            l = new ArrayList<Integer>();
                            atleast.add(i, l);
                      }
                      l.add(pi);
                 }
            }
            me = me == 0 ? (min > 0 ? min : 1) : me+1;
      } while (me < base);
 }