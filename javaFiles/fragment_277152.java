package org.mylib.schema;

import java.util.Locale;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelimitedSchemaType", propOrder = {
    "locale"
})
public class DelimitedDataSchema {

    @XmlElement(required = true, type = XmlLocale.class)
    @XmlJavaTypeAdapter(LocaleXmlAdapter.class)
    protected Locale locale;

}