package anotherTest;

import java.util.List;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;

    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlElementWrapper;
    import javax.xml.bind.annotation.XmlElements;
    import javax.xml.bind.annotation.XmlRootElement;

    @XmlRootElement(name = "prsettings")
    public class MyContainer extends MyObject {

        private ObservableList<MyObject> children = FXCollections.observableArrayList();

        @XmlElements({ @XmlElement(name = "prsetting", type = MyObject.class) })
        public List<MyObject> getChildren() {
            return children;
        }

        public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append("children:");

            for (MyObject node : children) {
                sb.append("\n");
                sb.append("  " + node.toString());
            }
            return sb.toString();

        }
    }