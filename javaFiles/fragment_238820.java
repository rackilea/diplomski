@RequestMapping(value="{person}", method = RequestMethod.POST)
@ResponseBody
    public String savePerson(@RequestBody Person person) {
         // save person in database
        return "Saved person: " + person.getFname() +" "+ person.getLname();
    }