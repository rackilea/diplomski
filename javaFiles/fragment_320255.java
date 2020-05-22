public static String globalVarScope;


       @BeforeClass
       @Parameters({"xmlParam"}) 
       public void initialSetup(String xmlParam) {

            System.out.println("Parameter from XML is..: "+xmlParam);
            globalVarScope= xmlParam;   
        }   


        @Test         
        public void useMeAnywhere() {         

            System.out.println("Hey, I passed the param earlier and I can use it anywhere now :) ..: "+globalVarScope);    
        }    


        @Test(dataProvider="login8users") 
        @Parameters({"browser"})
        public void login8(String dataProvider1, String dataProvider2) {      

            System.out.println("Email from data provider is..: "+dataProvider1);
            System.out.println("Pass from data provider is..: "+dataProvider2);     
        }