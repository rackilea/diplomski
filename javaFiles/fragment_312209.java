@Entity
public class Parent {
  ...
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parent")
  private Child child;
  ...
}

@Entity
public class Child {

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    ...
    @Lob
    private byte[] data;
    ...
}