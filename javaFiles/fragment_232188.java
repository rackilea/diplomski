public class Operation extends AbstractOperation
{
  @OneToMany(mappedBy="operation")
  public Set<JobOperation> getJobOperations()
  {
    return this.jobOperations;
  }
}