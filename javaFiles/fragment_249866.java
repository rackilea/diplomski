@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value=StringAdapter.class, type=String.class)
})
package forum11894193;

import javax.xml.bind.annotation.adapters.*;