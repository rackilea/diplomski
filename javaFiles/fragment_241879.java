@RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> login(@RequestParam Integer p1) {
        Map<String, Object> map = new HashMap<>();
        map.put("p1", p1);
        map.put("somethingElse", "456");
        return map;
    }