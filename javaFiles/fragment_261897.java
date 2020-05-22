while(true) {
      int n = in.nextInt();
      if(n == 42) {
        break;    // You break here...
      }
      System.out.println(n); // ... so this is skipped...
   }
   // ... because execution resumes here.