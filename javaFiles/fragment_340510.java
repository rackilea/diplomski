@Autowired
private HttpServletRequest context;
@RequestMapping(value = "/an/data", method = RequestMethod.POST)
@ResponseBody
public String send() {
    System.out.println("EEE");
    try{
        ObjectInputStream obj =  new ObjectInputStream(context.getInputStream());
        DataObj v = (DataObj )obj.readObject();
        System.out.println(v.getStringData());
    }catch(Exception e){
        e.printStackTrace();
    }
return "CAME";
}