@GET
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public Practicas getPracticasUsuario(@QueryParam("idUsuario") Integer idUsuario) {
    final List<Practica> listaPracticas;
    if (idUsario != null) {
        practicaDao.getPracticasByUser(idUsuario);
    } else {
        practicaDao.getPracticas();
    }
    Practicas practicas = new Practicas();
    practicas.setPracticas(listaPracticas);
    return practicas;

}