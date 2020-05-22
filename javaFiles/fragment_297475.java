@Resource 
BetaClass something;  // Wires to beanBeta - by-type

@Resource 
BetaClass beanAlpha;  // Will throw exception, because "beanAlpha" is not BetaClass -> it's a bad idea to use @Resource as a replacement of @Autowired

@Resource 
Object beanAlpha;  //Wires to beanAlpha - by-name