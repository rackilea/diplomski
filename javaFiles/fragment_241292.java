Constructor constructor = new Constructor(YamlTestDataFile.class);
TypeDescription dataDesc = new TypeDescription(YamlTestDataFile.class);
dataDesc.putListPropertyType("tests", YamlTestDataFile.Test.class);
constructor.addTypeDescription(dataDesc);
Yaml yaml = new Yaml(constructor);
InputStream in = ClassLoader.getSystemResourceAsStream("testData.yml");
testData = yaml.loadAs(in, YamlTestDataFile.class);