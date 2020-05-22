private SomeService someService;

   private AnotherService anotherService;

   @Resource
   public void setSomeService(SomeService someService){
      this.someService = someService;
   }

   @Resource
   public void setAnotherService(AnotherService anotherService){
      this.anotherService = anotherService;
   }

 }