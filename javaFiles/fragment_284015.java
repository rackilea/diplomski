@Path("{id}")
@PUT
@Consumes("application/json")
@Produces("application/json")
public Organization edit(OrganizationDTO dto,
                     @PathParam("id") Long id) {
  // lookup entity from database
  Organization org = entityManager.find( Organization.class, entity.getId() );
  // map changable values to the entity
  org.setName( dto.getName() );
  org.setDescription( dto.getDescription() );
  org.setUser( entityManager.find( User.class, userId ) );
  dto.setUser( org.getUser() );
  // merge changes
  entityManager.merge( org );
  // return dto
  return dto;
}