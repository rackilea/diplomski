package org.w3._2005.atom;

import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import javax.xml.namespace.QName;

@XmlType(name = "generatorType", propOrder = {"value"})
public class GeneratorType {
    @XmlValue
    protected String value;

    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    @XmlAttribute
    protected String version;

    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlSchemaType(name = "anyURI")
    protected String base;

    @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();
}