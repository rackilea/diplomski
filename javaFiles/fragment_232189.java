public class Operation extends AbstractOperation
{
  @OneToMany
  @JoinColumn(name="STANDARD_OPERATION_ID")
  public Set<JobOperation> getJobOperations()
  {
    return this.jobOperations;
  }
}