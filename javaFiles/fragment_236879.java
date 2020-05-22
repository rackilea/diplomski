@Bean
public MTS getMts() {
    return new MTS() {

       @Override
       public SrvResponse sendMessage(MTSModel msg){           
         ...
       }
       @Override
       public SrvResponse sendMessage(MTSModel msg, Type type){
         ...
       }

    };
}