@RequestMapping(value="/AddVote")
@ResponseStatus(value = HttpStatus.OK)
public void AddVote(@RequestParam(value = "eventid",required = true) String eventid,
                    @RequestParam(value="msisdn") String msisdn,
                    @RequestParam(value = "opt")String opt){

    Event event = userDao.findEvent(eventid);
    Vote vote = event.createVote(); //This will create a vote for an event.

    vote.set.... //set your stuff.
    //It will cascade your vote to an event if you have a cascade sorted correctly as in the example above: cascade = CascadeType.ALL
}