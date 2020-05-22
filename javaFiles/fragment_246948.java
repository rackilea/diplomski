package com.test;

import java.util.List;

public class B {

    private List<C> cList;

    public List<C> getcList() {
        return cList;
    }

    public void setcList(List<C> cList) {
        this.cList = cList;
    }

    public static class C {

        private String fieldc1;
        private String fieldc2;

        public String getFieldc1() {
            return fieldc1;
        }

        public void setFieldc1(String fieldc1) {
            this.fieldc1 = fieldc1;
        }

        public String getFieldc2() {
            return fieldc2;
        }

        public void setFieldc2(String fieldc2) {
            this.fieldc2 = fieldc2;
        }
    }
}