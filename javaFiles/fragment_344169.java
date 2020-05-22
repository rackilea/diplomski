package org.life.java.so.questions;
   /**
     *
     * @author jigar
     */
    public class GetClassPath {
        public static void main(String[] args) {
            System.out.println(GetClassPath.class.getProtectionDomain().getCodeSource().getLocation().getPath());      
        }
    }