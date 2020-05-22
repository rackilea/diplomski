@RequestMapping(value = "addPoint", method = RequestMethod.POST)
public ResponseEntity<byte[]> addImgProvOption(
@RequestParam("iRow") int iRow,
@RequestParam("point") String point,
@RequestParam("size") String size,
@RequestParam("side") String side,
@RequestParam("type") String type,
@RequestParam("percentage") String percentage,
@ModelAttribute("myModel") MyModel myModel,
Model model)
{
  OptionsRow userRow = new OptionsRow (point,size,side, type, 25);
  myModel.addOptionsRow (userRow, 0);
  return new ResponseEntity<byte[]>(HttpStatus.ACCEPTED);
}