@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody
List<Greeting> greeting() {
    Greeting greeting1 = new Greeting(1, "One");
    Greeting greeting2 = new Greeting(2, "Two");
    List<Greeting> list = new ArrayList<>();
    list.add(greeting1);
    list.add(greeting2);
    return list;
}