String modelname = getNameFromExternalSource(); //Replace with real external source.
String modelcleanname = modeldir.getName().replaceAll("\\W", "");
ClassPool pool = ClassPool.getDefault();
String measurementclassname = "measurementtable_" + modelcleanname;
CtClass stagingmeasurementclass = pool.makeClass(measurementclassname);
stagingmeasurementclass.setSuperclass(pool.get(StagingMeasurementRecord.class.getName()));
stagingmeasurementclass.setModifiers(Modifier.PUBLIC);
ClassFile stagingmeasurementclassfile = stagingmeasurementclass.getClassFile();
ConstPool constpool = stagingmeasurementclassfile.getConstPool();
AnnotationsAttribute attribute = new AnnotationsAttribute(constpool,
        AnnotationsAttribute.visibleTag);
Annotation tableannotation = new Annotation(constpool, pool.get(Table.class.getName()));
tableannotation.addMemberValue("name", new StringMemberValue(measurementclassname, constpool));
tableannotation.addMemberValue("keyspace", new StringMemberValue("mykeyspace", constpool));
attribute.addAnnotation(tableannotation);
stagingmeasurementclassfile.addAttribute(attribute);
stagingmeasurementclass.addConstructor(
        CtNewConstructor.make(new CtClass[0], new CtClass[0], stagingmeasurementclass));
Class<? super StagingMeasurementRecord> myoutputclass = stagingmeasurementclass.toClass();
LOGGER.info("Created custom measurementtable class with the name " + myoutputclass.getName());