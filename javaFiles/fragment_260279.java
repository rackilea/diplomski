private final char uglyChar;

   @Autowired
   public UglifyServiceImpl(@Value("${ugly.char}") final char uglyCharFromAppProp){
       this.uglyChar = uglyCharFromAppProp;
   }