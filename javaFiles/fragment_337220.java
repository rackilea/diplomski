/**
 * Placeholder pattern to resolve for application index. The following order is used
 * to find the name:
 * <ul>
 * <li>{@code vcap.application.instance_index}</li>
 * <li>{@code spring.application.index}</li>
 * <li>{@code server.port}</li>
 * <li>{@code PORT}</li>
 * </ul>
 * This order favors a platform defined index over any user defined value.
 */`"${vcap.application.instance_index:${spring.application.index:${server.port:${PORT:null}}}}"`