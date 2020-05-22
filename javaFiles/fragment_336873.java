@RequestMapping("/hello")
public String helloSpring(Model m)
{
    m.addAttribute("message", "HelloSpring");
    return "hello";
}