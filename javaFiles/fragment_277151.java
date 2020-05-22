package org.mylib.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelimitedSchemaType", propOrder = {
   "locale"
})
public class DelimitedDataSchema {

@XmlElement(required = true)
protected XmlLocale locale; // XmlLocale instead of Locale (java.util.Locale)

}