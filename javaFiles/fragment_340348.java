@Around(
  "execution(* findAll(*)) && " +
  "args(pageable) && " + 
  "target(jpaRepository) && " +
  //"within(org.springframework.data.jpa.repository.JpaRepository+) && " +
  "within(org.springframework.data.jpa.repository.JpaSpecificationExecutor+)"
)
public Object filterQueriesByCompany(ProceedingJoinPoint thisJoinPoint, Pageable pageable, JpaRepository jpaRepository) throws Throwable {
  return ((JpaSpecificationExecutor) jpaRepository)
    .findAll(CompanySpecification.fromCompany(user), pageable);
}