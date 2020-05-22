@Timed
@RequestMapping(value = "saveee/{id}", method = RequestMethod.POST)
@ResponseBody
public JsonResultBean saveTicketTemplate(@RequestBody TicketTemplateFieldBean fieldBean, @PathVariable("id") Long id) throws IOException {
    //TODO smth
    return JsonResultBean.success();
}