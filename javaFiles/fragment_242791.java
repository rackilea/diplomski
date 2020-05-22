public int deleteDefDialog(DefDialog defDialog) {
    DialogMapper dialogMapper = ConnectionHandler.getSession()
            .getMapper(DialogMapper.class);
    int i = dialogMapper.deleteDefDialog(defDialog);
    return i;
 }


public DefDialog selectDefDialog(BigDecimal i) {
    DialogMapper dialogMapper = ConnectionHandler.getSession()
            .getMapper(DialogMapper.class);
    return dialogMapper.selectDefDialog(i);
}