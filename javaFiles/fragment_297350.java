public CPDatosDocente obtenerFechaPosesionIdNombramiento(String tipoIdentificacion,
        String numeroIdentificacionDocente) {
    SqlSession session = sf.openSession();
    try {
        // Se abre conexión con el mapper
        CPDatosDocenteMapper mapper = session.getMapper(CPDatosDocenteMapper.class);
        // Se ejecuta la consulta para obtener la fecha de posesión y el
        // tipo de nombramiento
        CPDatosDocente datosDocente = new CPDatosDocente();
        //Se setean los parámetros necesarios para ejecutar el procedimiento
        datosDocente.setTipoIdentificacion(tipoIdentificacion);
        datosDocente.setNumeroIdentificacion(numeroIdentificacionDocente);          
        mapper.obtenerDatosFechaPosesionIdNombramiento(datosDocente);
        return datosDocente;
    } finally {
        session.close();
    }

}