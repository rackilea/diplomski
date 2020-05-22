for (int i=0;i<N;i++) {
      try {
        obj.getClass().getMethod("method"+i).invoke(obj);
      } catch (Exception e) {
         // give up
         break;
      }
    }