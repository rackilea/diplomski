import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.oxm.mappings.XMLCompositeObjectMapping;
import org.eclipse.persistence.oxm.mappings.nullpolicy.XMLNullRepresentationType;

public class RootEntityCustomizer implements DescriptorCustomizer {

    @Override
    public void customize(ClassDescriptor descriptor) throws Exception {
        XMLCompositeObjectMapping entityTwoMapping = (XMLCompositeObjectMapping) descriptor.getMappingForAttributeName("entityTwo");

        entityTwoMapping.getNullPolicy().setNullRepresentedByEmptyNode(true);
        entityTwoMapping.getNullPolicy().setMarshalNullRepresentation(XMLNullRepresentationType.EMPTY_NODE);
    }

}