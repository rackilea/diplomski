@RestController
public class controller{

    @RequestMapping(....)
    public ResponseEntity methodOne(@Validated(MethodOne.class) @RequestBody Person person){
        .....
    }

    @RequestMapping(....)
        public ResponseEntity methodTwo(@Validated(MethodTwo.class) @RequestBody Person person){
        ......
    }
}