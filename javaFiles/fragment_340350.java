@Around(
  "target(jpaSpecificationExecutor) && " +
  "execution(* org.springframework.data.jpa.repository.JpaRepository+.findAll(*)) && " +
  "args(pageable)" 
)
public Object filterQueriesByCompany(ProceedingJoinPoint thisJoinPoint, Pageable pageable, JpaSpecificationExecutor jpaSpecificationExecutor) throws Throwable {
  return jpaSpecificationExecutor.findAll(CompanySpecification.fromCompany(user), pageable);
}