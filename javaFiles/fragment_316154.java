/* Notes on the contents of this policy file:
 *
 * The following methods in groovy have privileged operations wrapping
 * setAccessible.  If these wrappers are not provided, most codebases below
 * must have the following grant: 
 * permission java.lang.reflect.ReflectPermission "suppressAccessChecks";
 *  MetaMethod.createMetaMethod
 *  MetaMethod.invoke(Object Object[])
 *  ReflectionMetaMethod.invoke(Object Object[])
 *  DefaultGoovyMethods.dump(Object)
 */