@RequestMapping(value ="/getdata",method = RequestMethod.GET , params = "par")  
public @ResponseBody  
List<Profissoes> getProfissoes(@RequestMapping("par") long value)  {
        System.out.println("Value "+value);
        // use it further the way u want
    }