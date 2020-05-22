@RequestMapping(value="/addS",method={RequestMethod.POST})

public String addEmployee(@RequestBody Num num){

    return "employee added successfully(Separate): "+num.name;
}