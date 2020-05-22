@ManyToMany
@JoinTable(
      name="car_worker",
      joinColumns=@JoinColumn(name="WORKER_ID", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="CAR_ID", referencedColumnName="ID"))
private Set<Car> cars;