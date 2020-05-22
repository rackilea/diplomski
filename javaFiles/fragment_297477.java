/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;

/**
*
* @author Nandeshwar
*/
public class FileExample {

 public static void main(String[] args) {
    File inFile = new File("c:/users/toshiba/desktop/MyText.txt");

    FileReader ins = null;

    try {
        ins = new FileReader(inFile);

        int ch;
        while ((ch = ins.read()) != -1) {
            System.out.println((char) ch);

        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        try {
            ins.close();
        } catch (Exception e) {
        }
    }
 }

}