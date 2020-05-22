package com.test;

import java.util.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class I2Adapter extends XmlAdapter<I2Adapter.AdaptedI2, Map<String, IInterface2>> {

    @Override
    public AdaptedI2 marshal(Map<String, IInterface2> v) throws Exception {
        if(null == v) {
            return null;
        }
        AdaptedI2 adaptedI2 = new AdaptedI2();
        for(Map.Entry<String,IInterface2> entry : v.entrySet()) {
            adaptedI2.entry.add(new Entry(entry.getKey(), entry.getValue()));
        }
        return adaptedI2;
    }

    @Override
    public Map<String, IInterface2> unmarshal(AdaptedI2 v) throws Exception {
        if(null == v) {
            return null;
        }
        Map<String, IInterface2> map = new HashMap<String, IInterface2>();
        for(Entry entry : v.entry) {
            map.put(entry.key, entry.value);
        }
        return map;
    }

    public static class AdaptedI2 {
        public List<Entry> entry = new ArrayList<Entry>();
    }

    public static class Entry {
        public Entry() {
        }

        public Entry(String key, IInterface2 value) {
            this.key = key;
            this.value = value;
        }

        public String key;

        @XmlElement(type=Interface2Impl.class)
        public IInterface2 value;
    }

}