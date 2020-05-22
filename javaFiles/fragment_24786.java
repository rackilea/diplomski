@Service("MyConversionService")
public class ApplicationConversionService extends DefaultConversionService {

public ApplicationConversionService() {
    addDefaultConverters();
    addDefaultAliases();
    addConverter("tagConverter", new TagsUtils());
}
}