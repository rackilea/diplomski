@Test
public void testGetIt() {
    // Get all list
    WidgetList list = target.path("widgets")
                            .request().get(WidgetList.class);
    System.out.println("===== Response from GET =====");
    for (Widget widget: list.getWidgetList()) {
        System.out.println("id: " + widget.getId() 
                         + ", name: " + widget.getName());
    }

    // Post one 
    Widget widget = Widget.newBuilder().setId("10")
                          .setName("widget 10").build();
    Response responseFromPost = target.path("widgets").request()
            .post(Entity.entity(widget, "application/protobuf"));
    System.out.println("===== Response from POST =====");
    System.out.println(responseFromPost.readEntity(String.class));
    responseFromPost.close();
}