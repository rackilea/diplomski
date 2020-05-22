@Service
class Foo{
  @Autowired
  Foo(@Value("${my.property}")int delay){
    ...
   }
}