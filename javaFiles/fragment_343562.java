module AlienDB {
    requires static lombok;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires com.sun.xml.bind; 
    requires net.bytebuddy;

    opens Aliens to org.hibernate.orm.core;


    exports Aliens;

}