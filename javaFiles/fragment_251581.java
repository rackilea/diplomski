protected List<String> getSecurityRoles() {
    List<String> roles = new ArrayList<String>();
    ServletContext sc = this.getServletContext();
    InputStream is = sc.getResourceAsStream("/WEB-INF/web.xml");

    try {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(is);

        Element webApp = doc.getRootElement();

        // Type safety warning:  dom4j doesn't use generics
        List<Element> roleElements = webApp.elements("security-role");
        for (Element roleEl : roleElements) {
            roles.add(roleEl.element("role-name").getText());
        }
    } catch (DocumentException e) {
        e.printStackTrace();
    }

    return roles;
}