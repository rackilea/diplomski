import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;


import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class MemExample {

    private static Sigar sigar = new Sigar();

    public static void getInformationsAboutMemory() {
        System.out.println("**************************************");
        System.out.println("*** Informations about the Memory: ***");
        System.out.println("**************************************\n");

        Mem mem = null;
        try {
            mem = sigar.getMem();
        } catch (SigarException se) {
            se.printStackTrace();
        }

        System.out.println("Actual total free system memory: "
                + mem.getActualFree() / 1024 / 1024+ " MB");
        System.out.println("Actual total used system memory: "
                + mem.getActualUsed() / 1024 / 1024 + " MB");
        System.out.println("Total free system memory ......: " + mem.getFree()
                / 1024 / 1024+ " MB");
        System.out.println("System Random Access Memory....: " + mem.getRam()
                + " MB");
        System.out.println("Total system memory............: " + mem.getTotal()
                / 1024 / 1024+ " MB");
        System.out.println("Total used system memory.......: " + mem.getUsed()
                / 1024 / 1024+ " MB");

        System.out.println("\n**************************************\n");


    }

    public static void main(String[] args) throws Exception{

                getInformationsAboutMemory();

                }

}