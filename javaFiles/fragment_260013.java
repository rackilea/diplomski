@RestController
@RequestMapping("${spring.data.rest.base-path}" + "/player")
public class PlayerRestResource {

    //This method can be accessed from /player/3
    //Id need to be placed in curly. 3 from url will be passed to the method
    @RequestMapping(path = "/{playerId}", method = RequestMethod.POST)
    //Use @PathVariable to bind the value from to url to the method parameter.
    public ResponseEntity<Player> getPlayer(@PathVariable("playerId") int playerId) {
    }

    //This is just like the above method.
    //This method can be accessed from /player/3/game/5
    @RequestMapping(path = "/{playerId}/game/{gameId}" method = RequestMethod.POST)
    public ResponseEntity<List<Game>> getGame(@PathVariable("playerId) int playerId, @PathVariable("gameId) int gameId) {
    }

}