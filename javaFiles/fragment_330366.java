package persistence.v1.dao.jpa2.listeners;

import java.lang.reflect.Method;
import java.sql.Types;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.internal.descriptors.MethodAttributeAccessor;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectToFieldMapping;
import org.eclipse.persistence.mappings.structures.ObjectRelationalDatabaseField;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventListener;

import com.vividsolutions.jts.geom.Geometry;

public class GeometryInitializerSessionEventListener implements SessionEventListener {

// Omitting empty interface methods

@Override
public void preLogin(SessionEvent event) {

    Session s = event.getSession();

    @SuppressWarnings("rawtypes")
    Map<Class, ClassDescriptor> descriptorMap = s.getDescriptors();

    for (@SuppressWarnings("rawtypes") Entry<Class, ClassDescriptor> entry : descriptorMap.entrySet()) {
        Class<?> cls = entry.getKey();
        ClassDescriptor desc = entry.getValue();

        Vector<DatabaseMapping> mappings = desc.getMappings();
        for(DatabaseMapping mapping:mappings) {

            if (mapping.getAttributeAccessor() instanceof MethodAttributeAccessor) {
                MethodAttributeAccessor maa = (MethodAttributeAccessor) mapping.getAttributeAccessor();

                String methodName = maa.getGetMethodName();

                Method method;
                try {
                    method = cls.getMethod(methodName, new Class[]{});
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (SecurityException e) {
                    throw new RuntimeException(e);
                }

                Class<?> returnType = method.getReturnType();

                if(Geometry.class.equals(returnType)) {

                    DirectToFieldMapping directToFieldMapping = (DirectToFieldMapping) mapping;

                    ObjectRelationalDatabaseField objectRelationalDatabaseField = new ObjectRelationalDatabaseField(mapping.getField());
                    objectRelationalDatabaseField.setSqlType(Types.STRUCT);
                    objectRelationalDatabaseField.setSqlTypeName("MDSYS.SDO_GEOMETRY");
                    directToFieldMapping.setField(objectRelationalDatabaseField);
                }
            }
        }
    }
}
}