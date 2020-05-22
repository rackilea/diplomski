@RequestMapping(value = "/sparql/question", method = RequestMethod.POST, params = "tb_age")public String tb_age(Model model) {
return "sparqlanswer   tb_age";}

@RequestMapping(value = "/sparql/question", method = RequestMethod.POST, params = "dc_age")
public String dc_age(Model modeld) {
    return "sparqlanswer  dc_age";}

@RequestMapping(value = "/sparql/question", method = RequestMethod.POST, params = "tb_name")public String tb_name(Model model) {
return "sparqlanswer  tb_name";}