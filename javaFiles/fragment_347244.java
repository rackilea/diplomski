@ProviderFor(EclipseAnnotationHandler.class)
public class HandleEntityData extends EclipseAnnotationHandler<EntityData> {

 public final static ConfigurationKey CONFIGURATION_KEY = new ConfigurationKey<FlagUsageType>("lombok.entity.flagUsage", 
                    "Emit a warning or error if @EntityData is used.") {};

@Override
    public void handle(AnnotationValues<EntityData> annotation,
            Annotation ast,
            EclipseNode annotationNode) {

        handleFlagUsage(
             annotationNode, 
             CONFIGURATION_KEYS, 
                        "@EntityData"
        ); 


}