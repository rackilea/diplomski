@Controller
@RequestMapping(value = "/rooms/{roomId}", method = RequestMethod.GET, produces="application/json")
@ResponseBody
public Room getRoom(@PathVariable String roomId, ModelMap modelMap) {    
    return bookingService.getRoomById(roomId);
}