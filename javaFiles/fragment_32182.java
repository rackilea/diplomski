@RequestMapping(path = "/create-guest/{weddingId}", method = RequestMethod.POST)
public List <Invite> guestList(@PathVariable(value="weddingId") String weddingId, @RequestBody Invite invite){
    Wedding wedding = weddings.findOne(Integer.valueOf(weddingId)); 
    wedding.invite = invite;
    invites.save(invite);
    return (List) wedding.invite;
}