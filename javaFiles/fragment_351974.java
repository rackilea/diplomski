public final class MigLayout implements LayoutManager2, Externalizable
{
    // ******** Instance part ********

    /** The component to string constraints mappings.
     */
    private final Map<Component, Object> scrConstrMap = new IdentityHashMap<Component, Object>(8);

    /** Hold the serializable text representation of the constraints.
     */
    private Object layoutConstraints = "", colConstraints = "", rowConstraints = "";    // Should never be null!

    // ******** Transient part ********

    private transient ContainerWrapper cacheParentW = null;

    private transient final Map<ComponentWrapper, CC> ccMap = new HashMap<ComponentWrapper, CC>(8);
    private transient javax.swing.Timer debugTimer = null;

    private transient LC lc = null;
    private transient AC colSpecs = null, rowSpecs = null;
    private transient Grid grid = null;
    private transient int lastModCount = PlatformDefaults.getModCount();
    private transient int lastHash = -1;
    private transient Dimension lastInvalidSize = null;

    private transient ArrayList<LayoutCallback> callbackList = null;

    private transient boolean dirty = true;