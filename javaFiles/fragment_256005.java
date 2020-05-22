// run with `spring run --watch <file>.groovy`
@Grab('com.vaadin:vaadin-spring-boot-starter:2.0.1')

import com.vaadin.ui.*
import com.vaadin.ui.themes.*
import com.vaadin.shared.*

@groovy.transform.Immutable
class Point {
        BigDecimal x,y
}

@com.vaadin.spring.annotation.SpringUI
@com.vaadin.annotations.Theme("valo")
class MyUI extends UI {
        protected void init(com.vaadin.server.VaadinRequest request) {
                def g = new Grid<Point>(Point)
                g.items = [new Point(0,0), new Point(1,1)]
                while (g.headerRowCount) {
                        g.removeHeaderRow(0)
                }
                content=g
        }
}