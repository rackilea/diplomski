@RequestMapping(value = {"/{foo3}"}, method = RequestMethod.GET)
    public @ResponseBody String fooMethod3(@PathVariable("foo3") String path) {
        path = "/" + path; // if you need "/"
        System.out.println("foo3 path: " + path);
        return "bar";
    }