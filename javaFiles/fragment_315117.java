package org.w3._2005.atom;

import java.math.BigInteger;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import javax.xml.namespace.QName;

@XmlType(name = "linkType", propOrder = {"content"})
public class LinkType {
    @XmlValue
    protected String content;

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String href;

    @XmlAttribute
    protected String rel;

    @XmlAttribute
    protected String type;

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String hreflang;

    @XmlAttribute
    protected String title;

    @XmlAttribute
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger length;

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