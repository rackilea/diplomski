@Entity
class Car {
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "car", orphanRemoval = true)
  private Set<Driver> drivers;

  ...
}

@Entity
class Driver {
  @ManyToOne
  private Car car;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true)
  private Set<Penalty> penalties;

  ...
}

@Entity
class Penalty {
  @ManyToOne
  private Driver driver;

  ...
}