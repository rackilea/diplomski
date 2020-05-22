Compiled from "BaseClass.java"
public class de.scrum_master.app.BaseClass implements javax.sql.DataSource {
  (...)

  public java.sql.Connection getConnection() throws java.sql.SQLException;
    Code:
       0: getstatic     #58                 // Field ajc$tjp_0:Lorg/aspectj/lang/JoinPoint$StaticPart;
       3: aload_0
       4: aload_0
       5: invokestatic  #64                 // Method org/aspectj/runtime/reflect/Factory.makeJP:(Lorg/aspectj/lang/JoinPoint$StaticPart;Ljava/lang/Object;Ljava/lang/Object;)Lorg/aspectj/lang/JoinPoint;
       8: astore_1
       9: invokestatic  #70                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.aspectOf:()Lde/scrum_master/aspect/DataSourceConnectionAspect;
      12: aload_1
      13: invokevirtual #74                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.ajc$before$de_scrum_master_aspect_DataSourceConnectionAspect$1$19879111:(Lorg/aspectj/lang/JoinPoint;)V
      16: aconst_null
      17: areturn

  public java.sql.Connection getConnection(java.lang.String, java.lang.String) throws java.sql.SQLException;
    Code:
       0: aload_1
       1: astore        4
       3: aload_2
       4: astore        5
       6: getstatic     #77                 // Field ajc$tjp_1:Lorg/aspectj/lang/JoinPoint$StaticPart;
       9: aload_0
      10: aload_0
      11: aload         4
      13: aload         5
      15: invokestatic  #80                 // Method org/aspectj/runtime/reflect/Factory.makeJP:(Lorg/aspectj/lang/JoinPoint$StaticPart;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/aspectj/lang/JoinPoint;
      18: astore_3
      19: invokestatic  #70                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.aspectOf:()Lde/scrum_master/aspect/DataSourceConnectionAspect;
      22: aload_3
      23: invokevirtual #74                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.ajc$before$de_scrum_master_aspect_DataSourceConnectionAspect$1$19879111:(Lorg/aspectj/lang/JoinPoint;)V
      26: aconst_null
      27: areturn

  (...)
}