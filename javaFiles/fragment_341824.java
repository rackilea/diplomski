public enum Status {
    OK, FAIL, NONE;
}

public Status getStatus() {
   if (this.getJavaBuildTotal() > 0 && 
        this.getJavaBuildBroke() == 0 && 
        this.getCeeBuildBroke() == 0 && 
        this.getJavaBuildInvalid() == 0 && 
        !this.hasBuildException()) {
      return OK;
   }
   else if (this.getJavaBuildTotal() == 0 && this.getCeeBuildTotal() == 0) {
      return NONE;
   }
   return FAIL;
}