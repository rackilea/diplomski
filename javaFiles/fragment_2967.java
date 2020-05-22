@Entity
class A {
  @Id
  Integer id;
  @OneToMany(mappedBy="a")
  List<AB> abList;
}

@Entity
class B {
  @Id
  Integer id;
  @OneToMany(mappedBy="b")
  List<AB> abList;
}

@Entity
@IdClass(ABId.class)
class AB {
  @Id
  @ManyToOne
  public A a;
  @Id
  @ManyToOne
  public B b;
  @OneToMany(mappedBy="ab")
  List<ABC> abcList;
}

class ABId {
  public Integer a;
  public Integer b;
}

@Entity
@IdClass(ABCId.class)
class ABC {
  @Id
  @ManyToOne
  public AB ab;
  @Id
  @ManyToOne
  public C c;
  @ManyToMany
  List<D> dList;
}

class ABCId {
  public ABId ab;
  public Integer c;
}