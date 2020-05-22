enum RootAdoper{

     A{
        @Overide
        public RootClass translate(RemoteClass remote){
           //...
        }

        @Override
        public String getTypeToTranslate(){  
            return "A";
        }
     },
     ... // other types listed here similarly
     ;

  abstract RootClass translate(RemoteClass remote); 

  abstract String getTypeToTranslate();
}