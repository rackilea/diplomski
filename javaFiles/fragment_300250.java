@RequestMapping(value="/Tab/window/{window}/tab/{tab}", method = RequestMethod.GET)
public @ResponseBody VO read(@PathVariable String window, @PathVariable String tab, @RequestHeader(value="X-SessionId", required=false) String session_id) 
        throws CompiereAPIApplicationException  {
    //@RequestHeader("X-SessionId") 
    return service.read(window, tab);
}