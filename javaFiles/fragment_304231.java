public aspect PolicyEnforcement {

  pointcut project1Call() : call(* com.project1..*.*(..));
  pointcut inProject1() : within(com.project1..*);
  pointcut project2Call() : call(* com.project2..*.*(..));
  pointcut inProject2() : within(com.project2..*);

  declare error : project1Call() && inProject2()
    : "Project2 is not allowed to access Project1";
  declare error : project2Call() && inProject1()
    : "Project1 is not allowed to access Project2";
}