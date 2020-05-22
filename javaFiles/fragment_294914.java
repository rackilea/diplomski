package com.test;

import java.util.Vector;

public class TestCopy {

    private Vector<ClassToCopy> createCopy(Vector<ClassToCopy> classToCopy) {
        Vector<ClassToCopy> localVariable = new Vector<ClassToCopy>();
        for(ClassToCopy classVar:classToCopy)
            try {
                localVariable.add((ClassToCopy)classVar.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return localVariable;
    }

    public static void main(String[] args) {

        Vector<ClassToCopy> originalVector = new Vector<ClassToCopy>();

        TestCopy testCopy = new TestCopy();
        originalVector.add(new ClassToCopy(1));
        originalVector.add(new ClassToCopy(2));
        originalVector.add(new ClassToCopy(3));
        originalVector.add(new ClassToCopy(4));
        System.out.println(originalVector);

        Vector<ClassToCopy> copiedVector = testCopy.createCopy(originalVector);
        System.out.println(copiedVector);

    }

}