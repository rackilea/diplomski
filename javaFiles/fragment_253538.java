public class GlobalEntityInterceptor 
    extends EmptyInterceptor {
    @Override
    public boolean onSave(java.lang.Object entity, java.io.Serializable p2, java.lang.Object[] p3, java.lang.String[] p4, org.hibernate.type.Type[] p5) {   
  //first save - you can modify your entity fields
}
    @Override
    public boolean onFlushDirty(java.lang.Object entity, java.io.Serializable p2, java.lang.Object[] p3, java.lang.Object[] p4, java.lang.String[] p5, 
                                    org.hibernate.type.Type[] p6) { 
  //modification  - you can modify your entity fields 

}