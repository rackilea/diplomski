private void loadEntity()
{
    final EntityValueObject<Entity> entityDTO = new EntityValueObject<>();
    RequestUtils.inst(this).doGetArray(URL, (response) ->
            {
                entityDTO.setEntity(creating entity from json here);
                **call your method here which handled your entityDTO response / may be UI update**
            },
            (VolleyError error) -> Log.d("loading tag", error.toString()));

}