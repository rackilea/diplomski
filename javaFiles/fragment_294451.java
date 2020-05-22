@Embeddable
public class FormId implements java.io.Serializable
{
    /** Generated <code>serialVersionUID</code>. */
    private static final long serialVersionUID = 906178514456716120L;

    /** The code of the form. */
    @Column(name = "FRM_CD", nullable = false, length = 80)
    private String formCode;
    /** The version of the form. */
    @Column(name = "FRM_VR", nullable = false, precision = 2, scale = 2)
    private BigDecimal formVersion;

    ...
}