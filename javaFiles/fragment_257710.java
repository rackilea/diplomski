@Override
public byte[] getDocumentFile(Long id) {
    return documentDao.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Document not found: " + id))
                      .getFile();
}