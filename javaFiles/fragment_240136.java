Resource childResource = resourceResolver.getResource(child.getPath());
Node childNode = childResource.adaptTo(Node.class);
Node jcrContent = childNode.getNode("jcr:content");
NodeIterator childrenNodes = jcrContent.getNodes();

while(childrenNodes.hasNext()){
    Node next = childrenNodes.nextNode();
    String resourceType = next.getProperty("sling:resourceType").getString();
    if(resourceType.equals("foundation/components/parsys")){
        %><cq:include path="<%= next.getPath() %>" resourceType="foundation/components/parsys" /><%
        break;
    }
}