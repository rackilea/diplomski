for(int i=0;i<numberOfMedia;i++) {
  try {
    Method getterMethod = commonBean.getClass().getMethod("getMediaUrl"+i);
    getterMethod.invoke(commonBean);
  } catch(Exception e) {}
}