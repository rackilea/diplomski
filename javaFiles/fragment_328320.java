package com.ekanathk;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

class MapEntryComparator implements Comparator<Map<String, String>> {

    private String[] keysToCompare;

    //What are the key columns you want to compare ???
    public MapEntryComparator(String[] keysToCompare) {
        this.keysToCompare = keysToCompare;
    }

    @Override
    public int compare(Map<String, String> o1, Map<String, String> o2) {
        for(String s: keysToCompare) {
            //HANDLE NULLS if any
            int comparison = o1.get(s).compareTo(o2.get(s));
            if(comparison != 0) {
                return comparison;
            }
        }
        return 0;
    }

}
public class ComparatorCheck {

    @Test
    public void testSimple() {
        LinkedHashMap<String, String> m1 = getMapSample("X", "M", "C", "D");
        LinkedHashMap<String, String> m2 = getMapSample("A", "B", "C", "D");
        LinkedHashMap<String, String> m3 = getMapSample("A", "B", "C", "D");
        LinkedHashMap<String, String> m4 = getMapSample("A", "B", "X", "D");

        List<LinkedHashMap<String, String>> list = new ArrayList<LinkedHashMap<String,String>>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        MapEntryComparator comparator = new MapEntryComparator(new String[]{"k1", "k2", "k3"});

        Collections.sort(list, comparator);

        assertEquals(m2, list.get(0));
        assertEquals(m3, list.get(1));
        assertEquals(m4, list.get(2));
        assertEquals(m1, list.get(3));
    }

    private LinkedHashMap<String, String> getMapSample(String v1, String v2, String v3, String v4) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("k1", v1);
        map.put("k2", v2);
        map.put("k3", v3);
        map.put("k4", v4);
        return map;
    }
}