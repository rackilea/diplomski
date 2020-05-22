getResource
public URL getResource(String name)
Finds the resource with the given name. A resource is some data (images, audio, text, etc) that can be accessed by class code in a way that is independent of the location of the code.
The name of a resource is a '/'-separated path name that identifies the resource.

This method will first search the parent class loader for the resource; if the parent is null the path of the class loader built-in to the virtual machine is searched. That failing, this method will invoke findResource(String) to find the resource.

Parameters:
name - The resource name
Returns:
A URL object for reading the resource, or null if the resource could not be found or the invoker doesn't have adequate privileges to get the resource.
Since:
1.1