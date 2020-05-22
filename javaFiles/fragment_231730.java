private static final long MAXVALUE = Long.MAX_VALUE;//Get the long value first

    @RequestMapping(method = RequestMethod.GET)
    public void spittles(
            @RequestParam(value = "max", defaultValue = MAXVALUE+"") long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
       // return spittleRepository.findSpittles(max, count);
    }