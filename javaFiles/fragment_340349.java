@Around(
  "target(jpaSpecificationExecutor) && " +
  "execution(* findAll(*)) && " +
  "args(pageable) && " + 
  "within(org.springframework.data.jpa.repository.JpaRepository+)"
)
public Object filterQueriesByCompany(ProceedingJoinPoint thisJoinPoint, Pageable pageable, JpaSpecificationExecutor jpaSpecificationExecutor) throws Throwable {
  return jpaSpecificationExecutor.findAll(CompanySpecification.fromCompany(user), pageable);
}