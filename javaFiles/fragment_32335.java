@RequestMapping(value = { "/debugGet" }, method = RequestMethod.GET)
@ResponseBody
public List<String> debugGet(@RequestParam int timeout, int numObjects) throws InterruptedException {
    Thread.sleep(timeout);

    List<String> l = new ArrayList<String>();

    for (int i =0; i< numObjects; i++){
        l.add(new String());
    }


    return l;

}