package q1015732;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Custom ant task that binds a property name to a static member of a class file.
 * 
 * @author Montrose
 */
public class BindPropertyTask extends Task{
    private String _classFile = null;
    private String _fieldName = null;
    private String _propName = null;

    /**
     * Set the field name of the class.
     * 
     * @param fieldName
     */
    public void setFieldName(String fieldName){
        _fieldName = fieldName;
    }

    /**
     * The class file.
     * @param classFile
     */
    public void setClassFile(String classFile){
        _classFile = classFile;
    }

    /**
     * The property name to bind
     * @param propName
     */
    public void setProperty(String propName)
    {
        _propName = propName;
    }

    /**
     * Load the class file, and grab the value of the field.
     * 
     * Throws exceptions if classfile, fieldname, or property have not been set.
     * 
     * Throws more execeptions if classfile does not exist, the field does not exist, or the field is not static.
     */
    public void execute() throws BuildException{
        if(_classFile == null) throw new BuildException("ClassFile is a required attribute");
        if(_fieldName == null) throw new BuildException("FieldName is a required attribute");
        if(_propName == null)  throw new BuildException("Property is  required attribute");

        CustomLoader loader = new CustomLoader();
        Class toInspect = null;
        Field toBind = null;
        Object value = null;

        try {
            toInspect = loader.loadClass(new FileInputStream(_classFile));
        } catch (Exception e) {
            throw new BuildException("Couldn't load class ["+e.getMessage()+"], in ["+(new File(_classFile).getAbsolutePath())+"]");
        }

        try{
            toBind = toInspect.getField(_fieldName);
        }catch(NoSuchFieldException e){
            throw new BuildException("Couldn't find field, '"+_fieldName+"'");
        }

        //Let us bind to private/protected/package-private fields
        toBind.setAccessible(true);

        try{
            value = toBind.get(null);
        }catch(NullPointerException e){
            throw new BuildException("Field is not static");
        } catch (Exception e) {
            throw new BuildException("Unable to access field ["+e.getMessage()+"]");
        }

        if(value != null)
            this.getProject().setProperty(_propName, value.toString());
        else
            this.getProject().setProperty(_propName, null);
    }

    /**
     * Custom class loader, for loading a class directly from a file.
     * 
     * This is hacky and relies on deprecated methods, be wary.
     * 
     * @author Montrose
     */
    class CustomLoader extends ClassLoader{
        public CustomLoader(){
            super(ClassLoader.getSystemClassLoader());
        }

        /**
         * Warning, here be (deprecated) dragons.
         * @param in
         * @return
         * @throws Exception
         */
        @SuppressWarnings("deprecation")
        public Class loadClass(InputStream in) throws Exception{
            byte[] classData = loadData(in);
            return this.defineClass(classData, 0, classData.length);
        }

        private byte[] loadData(InputStream in) throws Exception{
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int i;


            while((i = in.read(buffer)) != -1){
                out.write(buffer, 0, i);
            }

            return out.toByteArray();
        }
    }
}