//get summary  of an employee
    @GetMapping(value = "summary/{id}")
    public List<Scrcrd> getSummary(@PathVariable String id) {
        return  scrcrdRepository.findAllById(Collections.singleton(id));
    }

    //get scrcrd record by id
    @GetMapping(value = "{id}")
    public Scrcrd get(@PathVariable String id) {
        return scrcrdRepository.getOne(id);
    }