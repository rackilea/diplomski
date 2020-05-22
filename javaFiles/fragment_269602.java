@ComponentScan({"com.mycompany.myapp.moduleB",
                "com.mycompany.myapp.moduleB.subpackage1",
                "com.mycompany.myapp.moduleB.subpackage1.subsubpackage1a",
                "com.mycompany.myapp.moduleB.subpackage2"
                 /*add here all required packages to scan for B's components and services*/ })
public class BConfig {}