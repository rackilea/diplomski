OptionsDisplayer displayer = OptionsDisplayer.getDefault();        
    Object impl = getField(displayer, "impl"); 
    if(impl != null){
        WeakReference<DialogDescriptor> descriptorRef = (WeakReference<DialogDescriptor>)getField(impl, "descriptorRef");
        if(descriptorRef != null){                
            DialogDescriptor descriptor = descriptorRef.get();
            //change default initial selected butten from "OK" to "CANCEL"
            descriptor.setValue(DialogDescriptor.CANCEL_OPTION); //change default initial selected butten from "OK" to "CANCEL"
        }
    }

/**
 * Java reflection utility method to get the Object for a given field regardless of whether it is private or not, by it's given field name.
 * @param obj The Object that contains the desired field.
 * @param fieldName The name of the field
 * @return The Object with the given fieldName found in Object 'obj'. Returns null if no such field exists.
 */
public static Object getField(Object obj, String fieldName) {
    Class tmpClass = obj.getClass();
    do {
        try {
            Field f = tmpClass.getDeclaredField(fieldName);
            if(f != null){
                f.setAccessible(true);
                return f.get(obj);
            }                
        } catch (NoSuchFieldException e) {
            tmpClass = tmpClass.getSuperclass();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    } while (tmpClass != null);
    return null; //null if not found
}