String[] strings = {
    "org.eclipse.aether:aether-impl:jar:0.9.0.M2:compile",
    "com.google.code.findbugs:annotations:jar:3.0.0:compile",
    "org.sonatype.sisu:sisu-guice:jar:no_aop:3.1.0:compile"
};        

for (String string: strings) {
    String[] coll = string.split(":");
    System.out.println("groupId: " + coll[0]);
    System.out.println("artifactId: " + coll[1]);
    if (coll.length == 5) {
        System.out.println("version: " + coll[3]);
    }
    if (coll.length == 6) {
        System.out.println("version: " + coll[4]);
    }            
    System.out.println();          
}