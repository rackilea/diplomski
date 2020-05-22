package com.foo.conf;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="checks")
public class Checks {       
    @XmlJavaTypeAdapter(ChecksAdapter.class)
    @XmlPath(".")
    public Map<String, Check> checkMap;     
}