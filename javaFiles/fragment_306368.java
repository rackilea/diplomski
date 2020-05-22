package com.example;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

import net.opengis.gml.v_3_1_1.AbstractFeatureType;
import net.opengis.gml.v_3_1_1.FeaturePropertyType;
import net.opengis.wfs.v_1_1_0.FeatureCollectionType;
import net.opengis.wfs.v_1_1_0.ObjectFactory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foo", propOrder = { "bar" })
public class Foo extends AbstractFeatureType {

    @XmlElement
    protected String bar = "0";

    @Override
    public Object createNewInstance() {
        return new Foo();
    }

    public static void main(String[] args) throws JAXBException {
        ObjectFactory wfsfactory = new ObjectFactory();
        net.opengis.gml.v_3_1_1.ObjectFactory gmlfactory = new net.opengis.gml.v_3_1_1.ObjectFactory();
        com.example.ObjectFactory exampleFactory = new com.example.ObjectFactory();
        FeatureCollectionType featureCollection = wfsfactory
                .createFeatureCollectionType();
        FeaturePropertyType prop = gmlfactory.createFeaturePropertyType();
        prop.setFeature(exampleFactory.createFoo(exampleFactory.createFoo()));
        featureCollection.setFeatureMember(Arrays.asList(prop));
        //marshal to XML
        JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class, net.opengis.gml.v_3_1_1.ObjectFactory.class, com.example.ObjectFactory.class);

        StringWriter sw =new StringWriter();
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(wfsfactory.createFeatureCollection(featureCollection), sw);
        System.out.println(sw.toString());

        //unmarshal back to object
        JAXBElement<FeatureCollectionType> afterMarshal = (JAXBElement<FeatureCollectionType>)
            ctx.createUnmarshaller().unmarshal(new StringReader(sw.toString()));

        JAXBElement<? extends AbstractFeatureType> feature = afterMarshal
                .getValue().getFeatureMember().get(0).getFeature();
        if (feature == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
    }
}