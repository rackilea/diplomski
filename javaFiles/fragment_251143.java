public void display() {
        Link pcurrent = pfirst;
        while(pcurrent!= null) {
                System.out.println(pcurrent);
                pcurrent = pcurrent.next;
         }
   }