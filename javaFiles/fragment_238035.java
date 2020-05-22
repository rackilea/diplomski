@Entity
@Table(name = "t_virtual_document")
public class VirtualDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private long documentId;

    @Column(name = "real_url", unique = true)
    private String realURL; //uniq

    @Column(name = "virtual_url", unique = true)
    private String virtualURL; //uniq

    @Column(name = "simulation_mode", columnDefinition = "varchar(10) default 'STOP'")
    private String simulationMode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virtualDocument")
    private List<VirtualRequest> requestList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virtualDocument")
    // Note the mappedBy parameter. This points to the property in the entity that owns the relationship (in this case the VirtualResponse).
    private List<VirtualResponse> responseList;

   //getter setter without any annotation
}

@Entity
@Table(name = "t_virtual_request")
public class VirtualRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private long requestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private VirtualDocument virtualDocument;

    @Column(name = "request_url")
    private String requestURL;

    @Column(name = "method_type")
    private String methodType;

    @Column(name = "media_type")
    private String mediaType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virtualRequest")
    private List<HttpHeaderList> requestHeaders;

   //getter setter without any annotation
}

@Entity
@Table(name = "t_http_headers")
public class HttpHeader { /*Note this is a more appropriate name for the entity since it holds the data of a single header.*/

    @Id
    @Column(name = "header_id")
    private long headerId;

    @Column(name = "header_key")
    private String headerKey;

    @Column(name = "header_value")
    private String headerValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    private VirtualRequest virtualRequest

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id")
    private VirtualResponse virtualResponse;
}