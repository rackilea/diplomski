public static int[] eliminateDuplicates(int[] list){   
     List<Integer> noDup = new ArrayList<Integer>(); 
     noDup.add(list[0]);
     for (int c = 1; c < list.length-1; c++){
         if(!noDup.contains(list[c])){
             noDup.add(list[c]); 
         }
     }
     int[] noDupArray = new int[noDup.size()];
     for(int i = 0; i < noDup.size(); i++){
         noDupArray[i] = noDup.get(i);
         System.out.println(noDup.get(i));
     } 
     return noDupArray;
}