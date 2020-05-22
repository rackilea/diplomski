@Service("conversionService")
public class MyConversionService extends DefaultConversionService {

    public void ConversionService() {
        addDefaultConverters();
    }

    @Override
    protected void addDefaultConverters() {
        super.addDefaultConverters();
    }

}