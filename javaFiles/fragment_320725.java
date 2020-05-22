package com.sandbox;

import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {

        Comparator comp = new MyComparator();
        // compiler error - Method is undefined for the type Comparator<String>
        comp.setText("xyz");

    }

    private static class MyComparator implements Comparator<String> {

        private String sample = null;

        @Override
        public int compare(String arg0, String arg1) {
            // TODO Auto-generated method stub
            return arg0.compareTo(arg1);
        }

        public void setText(String t1) {
            sample = t1;
        }

    }


}