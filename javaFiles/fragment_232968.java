module com.company.getworks.start {
    requires spring.boot;
    requires spring.webmvc;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.web;
    opens com.company.getworks.start;
    exports com.company.getworks.web;
}