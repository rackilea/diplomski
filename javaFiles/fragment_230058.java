@Grapes([
        @Grab('org.vaadin.spring:spring-boot-vaadin:0.0.3'),
        @Grab('com.vaadin:vaadin-client-compiled:7.4.0.beta1'),
        @Grab('com.vaadin:vaadin-themes:7.4.0.beta1'),
       ])
import com.vaadin.ui.*

@org.vaadin.spring.VaadinUI
class MyUI extends UI {

    protected void init(com.vaadin.server.VaadinRequest request) {
        final headerLayout = new VerticalLayout(new Label('HEADER'))
        final footerLayout = new VerticalLayout(new Label('FOOTER'))

        final contentLayout = new VerticalLayout()
        80.times{ contentLayout.addComponent(new Button("TEST $it")) }
        // XXX: place the center layout into a panel, which allows scrollbars
        final contentPanel = new Panel(contentLayout)
        contentPanel.setSizeFull()

        // XXX: add the panel instead of the layout
        final mainLayout = new VerticalLayout(headerLayout, contentPanel, footerLayout)
        mainLayout.setSizeFull()
        mainLayout.setExpandRatio(contentPanel, 1)
        setContent(mainLayout)
    }

}