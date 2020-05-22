public void copieFichierDansRichText(String idDocument, String nomRti, File file,
        String nameFichier, String chemin) throws NotesException {

    lotus.domino.Session session = Utils.getSession();
    lotus.domino.Database db = session.getCurrentDatabase();
    lotus.domino.Document monDoc = db.getDocumentByUNID(idDocument);

    try {
        if (monDoc != null) {
            lotus.domino.RichTextItem rtiNew = (lotus.domino.RichTextItem) monDoc
                    .getFirstItem(nomRti);
            PieceJointe pieceJointe = new PieceJointe();
            pieceJointe = buildPieceJointe(file, nameFichier, chemin);

            rtiNew.embedObject(EmbeddedObject.EMBED_ATTACHMENT, "", pieceJointe.getChemin()
                    + pieceJointe.getNomPiece(), pieceJointe.getNomPiece());
            monDoc.computeWithForm(true, true);
            monDoc.save(true);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}