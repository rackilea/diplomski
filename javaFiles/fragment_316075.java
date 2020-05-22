if (helperWrapper == null) {
     synchronized(this) {
       if (helperWrapper == null) {
          helperWrapper = new FinalWrapper<Helper>(new Helper());
       }
     }
}