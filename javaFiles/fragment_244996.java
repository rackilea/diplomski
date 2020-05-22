@Controller
public class Login {
@RequestMapping(value="/login", method=RequestMethod.POST)
public @ResponseBody String testLogin(@RequestBody LoginInfo login) throws MyException{
    if (login.getUser().equals("test") && login.getPass().equals("1234")){
        return true;
    } else {
        return false;
        throw new MyException("Wrong login info");
    }
}