package com.test;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class Main5 {

    public static void main(String[] args) throws Exception {
        List<String> mappingFiles = new ArrayList<String>(1);
        mappingFiles.add("mapping.xml");

        Mapper mapper = new DozerBeanMapper(mappingFiles);

        A a = new A();
        a.setFielda1("fielda1Value");
        a.setFielda2("fielda2Value");

        B.C destObject = mapper.map(a, B.C.class, "test");

        System.out.println(destObject.getFieldc1());
        System.out.println(destObject.getFieldc2());
    }

}