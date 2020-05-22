CpeDescription cpeDesc = UIMAFramework.getXMLParser().parseCpeDescription(new XMLInputSource(cpeFile));
File rootFolder = new File(cpeDesc.getSourceUrl().getFile()).getParentFile();
ArrayList<TypeSystemDescription> typeSystems = new ArrayList<>();

for(CpeCollectionReader collReader : cpeDesc.getAllCollectionCollectionReaders()){
    File descFile = new File(rootFolder + System.getProperty("file.separator") + collReader.getDescriptor().getImport().getLocation());

    CollectionReaderDescription crd = UIMAFramework.getXMLParser().parseCollectionReaderDescription(new XMLInputSource(descFile));

    TypeSystemDescription typeSystem = crd.getCollectionReaderMetaData().getTypeSystem();
    typeSystem.resolveImports();

    typeSystems.add(typeSystem);
}

for(CpeCasProcessor casProcessor : cpeDesc.getCpeCasProcessors().getAllCpeCasProcessors()){
    File descFile = new File(rootFolder + System.getProperty("file.separator") + casProcessor.getCpeComponentDescriptor().getImport().getLocation());

    AnalysisEngineDescription aed = UIMAFramework.getXMLParser().parseAnalysisEngineDescription(new XMLInputSource(descFile));

    TypeSystemDescription typeSystem = aed.getAnalysisEngineMetaData().getTypeSystem();
    typeSystem.resolveImports();

    typeSystems.add(typeSystem);
}

TypeSystemDescription mergedTypeSystem = CasCreationUtils.mergeTypeSystems(typeSystems);