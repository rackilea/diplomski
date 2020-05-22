package com.example;

public class MyHashMap<K, V> extends java.util.HashMap<K, V> {

    private int maxKeyLength = 0;
    private int maxValueLength = 0;

    @Override
    public V put(K key, V value) {
        maxKeyLength = Math.max(maxKeyLength, key.toString().length());
        maxValueLength = Math.max(maxValueLength, value.toString().length());
        return value;
    };

    public int getMaxKeyLength() {
        return maxKeyLength;
    }

    public int getMaxValueLength() {
        return maxValueLength;
    }
}