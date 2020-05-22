public interface Data {
   public Map<String,String>> getGlobalConf();
}

public interface DataFactory extends AutoBeanFactory {
   AutoBean<Data> getData();
}

final String jsObject = GeneralContextNativeReader.read("globalConf");
DataFactory dataFactory = GWT.create(DataFactory.class);
Data data = AutoBeanCodex.decode(dataFactory, Data.class, jsObject).as();
Map<String, String> globalConf = data.getGlobalConf();