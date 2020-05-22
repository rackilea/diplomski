/* register the natives via the static initializer.
 *
 * VM will invoke the initializeSystemClass method to complete
 * the initialization for this class separated from clinit.
 * Note that to use properties set by the VM, see the constraints
 * described in the initializeSystemClass method.
 */
private static native void registerNatives();
static {
    registerNatives();
}