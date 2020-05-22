@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class) 
@Override
public void altaArchivo(Mensaje objMensaje, ArchivoCarnet objArchivoCarnet, ArchivoCarnetTrailer objArchivoCarnetTrailer, List<ArchivoCarnetDetalle> lstArchivoCarnetDetalle) {

    if (objMensaje.getStrCodigo().equals(ArchivoErrorEnum.OPERACION_EXITOSA.getStrCodigo())) {
        archivoDAO.altaArchivoCarnet(objArchivoCarnet);
        archivoDAO.altaArchivoCarnetTrailer(objArchivoCarnetTrailer);
        archivoDAO.altaArchivoCarnetDetalle(lstArchivoCarnetDetalle);
    } else {
        archivoDAO.altaBitacoraArchivo510(new BitacoraArchivo510(objMensaje, objArchivoCarnet.getStrNombre()));
    }

}