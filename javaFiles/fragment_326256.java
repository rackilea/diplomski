@Entity
@IdClass(BPK.class)
public class B {
  @EmbeddedId
  BPK pk;
  @MapsId("apk")
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumns({
    @JoinColumn(name="f1", referencedColumnName="f1", nullable=false),
    @JoinColumn(name="f2", referencedColumnName="f2", nullable=false)
  })
  A a;
}

@Embeddable
public class BPK {
  String f5;
  String f6;
  APK apk;
}