import org.eclipse.persistence.exceptions.DescriptorException;
import org.eclipse.persistence.mappings.AttributeAccessor;

public class MyAttributeAccessor extends AttributeAccessor {

    private AttributeAccessor attributeAccessor;

    public MyAttributeAccessor(AttributeAccessor attributeAccessor) {
        this.attributeAccessor = attributeAccessor;
    }

    @Override
    public Object getAttributeValueFromObject(Object domainObject)
            throws DescriptorException {
        return attributeAccessor.getAttributeValueFromObject(domainObject);
    }

    @Override
    public void setAttributeValueInObject(Object domainObject, Object value)
            throws DescriptorException {
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Set value:  " + value + " on property: " + attributeAccessor.getAttributeName() + " for object: " + domainObject);
        attributeAccessor.setAttributeValueInObject(domainObject, value);
    }

}