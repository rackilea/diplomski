String main = "/Users/haddad/development/fspc/content/2017.dev/src/agency/individual/integration/src/forms/print.xml";
String ref = "../../../../include/masking.xml";

System.out.println(Paths.get(main));
System.out.println(Paths.get(main).resolveSibling(ref));
System.out.println(Paths.get(main).resolveSibling(ref).normalize());