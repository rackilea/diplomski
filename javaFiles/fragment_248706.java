Compiled from "BaseClass.java"
public class de.scrum_master.app.BaseClass {
  (...)

  public java.sql.Connection getConnection() throws java.sql.SQLException;
    Code:
       0: aload_0
       1: instanceof    #76                 // class javax/sql/DataSource
       4: ifeq          21
       7: invokestatic  #70                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.aspectOf:()Lde/scrum_master/aspect/DataSourceConnectionAspect;
      10: getstatic     #58                 // Field ajc$tjp_0:Lorg/aspectj/lang/JoinPoint$StaticPart;
      13: aload_0
      14: aload_0
      15: invokestatic  #64                 // Method org/aspectj/runtime/reflect/Factory.makeJP:(Lorg/aspectj/lang/JoinPoint$StaticPart;Ljava/lang/Object;Ljava/lang/Object;)Lorg/aspectj/lang/JoinPoint;
      18: invokevirtual #74                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.myAdvice:(Lorg/aspectj/lang/JoinPoint;)V
      21: aconst_null
      22: areturn

  public java.sql.Connection getConnection(java.lang.String, java.lang.String) throws java.sql.SQLException;
    Code:
       0: aload_1
       1: astore        4
       3: aload_2
       4: astore        5
       6: aload_0
       7: instanceof    #76                 // class javax/sql/DataSource
      10: ifeq          31
      13: invokestatic  #70                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.aspectOf:()Lde/scrum_master/aspect/DataSourceConnectionAspect;
      16: getstatic     #79                 // Field ajc$tjp_1:Lorg/aspectj/lang/JoinPoint$StaticPart;
      19: aload_0
      20: aload_0
      21: aload         4
      23: aload         5
      25: invokestatic  #82                 // Method org/aspectj/runtime/reflect/Factory.makeJP:(Lorg/aspectj/lang/JoinPoint$StaticPart;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/aspectj/lang/JoinPoint;
      28: invokevirtual #74                 // Method de/scrum_master/aspect/DataSourceConnectionAspect.myAdvice:(Lorg/aspectj/lang/JoinPoint;)V
      31: aconst_null
      32: areturn

  (...)
}