WeakReference<Object> ref = new WeakReference<Object>(new Object());
...
Object newRef = ref.get();
if ( newRef == null ) {
    //Use newRef reference to Object as needed
} else {
    //Object has been released by the GC
}