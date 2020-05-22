@Timed
@RequestMapping(value = "saveee", method = RequestMethod.POST)
@ResponseBody
public JsonResultBean saveTicketTemplate(@RequestBody TicketTemplateFieldBean fieldBean, @RequestParam("id") Long id) throws IOException {
    //TODO smth
    return JsonResultBean.success();
}