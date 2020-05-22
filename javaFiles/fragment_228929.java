boolean flag;

public boolean isFlag() {
     if(myBean == null) {
         myBean = new MyBean();
     } 
     return myBean.getFlag();
}

public void setFlag(boolean flag) {
      this.myBean.setFlag(flag); 
      this.flag = flag;
}