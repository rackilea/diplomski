/**
 * @goal set-properties
 * @phase validate
 * @since 0.1
 */
public class PropertySetterMojo extends AbstractMojo
{
    /**
     * @parameter default-value="${project}"
     * @parameter required
     * @readonly
     */
    private MavenProject project;

    /**
     *  @parameter expression="${session}"
     *  @readonly
     */
    private MavenSession session;

    /**
     * @parameter expression="${mojoExecution}"
     * @readonly
     * @required
     */
    protected MojoExecution execution;

    ...

}