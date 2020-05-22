@Entity
@IdClass(BPK.class)
public class B {
  @ID
  String f5;
  @ID
  String f6;
  @ID
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumns({
    @JoinColumn(name="f1", referencedColumnName="f1", nullable=false),
    @JoinColumn(name="f2", referencedColumnName="f2", nullable=false)
  })
  A a;
}

public class BPK {
  String f5;
  String f6;
  APK a;
}