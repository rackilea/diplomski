/**
 * @goal set-properties
 * @phase validate
 * @since 0.1
 * @requiresProject false 
 */
public class PropertySetterMojo extends AbstractMojo
{
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