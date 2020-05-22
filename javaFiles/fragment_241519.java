@ManyToMany
@JoinTable(
      name="car_worker",
      joinColumns=@JoinColumn(name="CAR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="WORKER_ID", referencedColumnName="ID"))
@WhereJoinTable(clause = "worker_type = 1")
private Set<Worker> workerIn;

@ManyToMany
@JoinTable(
      name="car_worker",
      joinColumns=@JoinColumn(name="CAR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="WORKER_ID", referencedColumnName="ID"))
@WhereJoinTable(clause = "worker_type = 2")
private Set<Worker> workerOut;

@ManyToMany
@JoinTable(
      name="car_worker",
      joinColumns=@JoinColumn(name="CAR_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="WORKER_ID", referencedColumnName="ID"))
@WhereJoinTable(clause = "worker_type = 3")
private Set<Worker> workerMain;