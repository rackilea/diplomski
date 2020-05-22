@Component
        public class SomeClass {
            @Autowired
            private MyService myService;
            public void someMethod(){
                  myService.transactionalMethod();//will be in transaction. Here actualy you go to the proxy first and then it calls the real method. 
                  myService.notTransactionalMethod();//will not be in transaction and hibernate will throw an error. 
                                                     //You go to the proxy, but doesent do anything special because the method is not transactional and it calls the real method, 
                                                     //but here you dont't got trough the proxy so the @Transactional is ignored.
            }
        }