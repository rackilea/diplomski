SoapHeader uName;
Document document = setCredentials(USERNAMETOKEN, this.username);
if (document != null) {
    uName = new SoapHeader(new QName(NAMESPACE_URL, USERNAMETOKEN), 
            document.getDocumentElement());
} else {
    // whatever you need to do
}