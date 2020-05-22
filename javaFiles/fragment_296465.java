@RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody ResponseEntity<Object> getAll() {
    List<Entity> entityList = entityManager.findAll();

    List<JSONObject> entities = new ArrayList<JSONObject>();
    for (Entity n : entityList) {
        JSONObject Entity = new JSONObject();
        entity.put("id", n.getId());
        entity.put("address", n.getAddress());
        entities.add(entity);
    }
    return new ResponseEntity<Object>(entities, HttpStatus.OK);
}