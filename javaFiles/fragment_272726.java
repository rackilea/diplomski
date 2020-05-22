@Id
@Basic(optional = false)
@Column(name = "ID", nullable = false)
@GenericGenerator(name = "seq_id", strategy = "com.yoncabt.abys.core.listener.CustomGenerator", parameters = { @Parameter(name = "sequence", value = "II_FIRM_DOC_PRM_SEQ") })
@GeneratedValue(generator = "seq_id")
private Long id;