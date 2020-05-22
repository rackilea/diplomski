for (Iterator<String> it = list1.iterator(); it.hasNext();) {
        String s = it.next();
        System.out.println(s.charAt(0));
   }
   for (Iterator<String> it = list1.iterator(); it.hasNext();) {
        String s1 = it.next();
        for (int i=2; i<s1.length(); i++){
            System.out.print(s1.charAt(i));
        }
        System.out.println();
   }