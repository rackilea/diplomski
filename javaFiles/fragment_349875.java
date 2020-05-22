package forum11698160;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class Bar extends Foo {

    public List<Thing> getThings() {
        return super.getThings();
    }

}