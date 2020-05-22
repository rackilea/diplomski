Properties cfg=new Properties();
cfg.load(new FileInputStream("features.properties"));//current directory, default encoding: take care 
if(cfg.getProperty("USE_ABC").equalsIgnoreCase("true")){
    features.add(new ABCFeatures());
} 
if(cfg.getProperty("USE_PRQ").equalsIgnoreCase("true")){
    features.add(new PRQFeatures(prq));
}