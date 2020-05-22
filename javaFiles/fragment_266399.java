String idCodice = null;
int startTag = cessionarioCommittente.indexOf("<IdCodice>");
int endTag = cessionarioCommittente.indexOf("</IdCodice>");
if (startTag >= 0 && endTag > startTag) {
    idCodice = cessionarioCommittente.substring(startTag + 10, endTag);
}