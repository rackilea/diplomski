Mapper.java:

@Select(value = "{CALL prc_ultimo_nombramiento(#{tipoIdentificacion,    mode=IN},#{numeroIdentificacion, mode=IN},#{idEt, jdbcType=VARCHAR},#{fechaPosesion, mode=OUT, jdbcType=VARCHAR},#{idTipoNombramiento, mode=OUT, jdbcType=VARCHAR},#{validar, jdbcType=VARCHAR},#{mensaje, jdbcType=VARCHAR})}")
@Options(statementType = StatementType.CALLABLE)
@ResultType(CPDatosDocente.class)
void obtenerDatosFechaPosesionIdNombramiento(CPDatosDocente datosDocente);
 //I put this field void because I don't need this method return nothing.

DAO.java