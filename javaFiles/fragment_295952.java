@Entity
public class QRequest {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "qRequest")
    private Quotation quotation;
}

@Entity
public class Quotation {
  @Id
  @GeneratedValue
  private long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "qr_id", nullable = false)
  private QRequest qRequest;
}


"Select qr from QRequest qr " +
"join qr.quotation q "