RuntimeMXBean RuntimemxBean = ManagementFactory.getRuntimeMXBean();
List<String> paramList=new ArrayList<String>();
paramList.addAll( RuntimemxBean.getInputArguments() );
paramList.add(  RuntimemxBean.getClassPath() );
paramList.add(  RuntimemxBean.getBootClassPath()  );
paramList.add(  RuntimemxBean.getLibraryPath()  );

for( String p : paramList ) {
    System.out.println( p ); 
}