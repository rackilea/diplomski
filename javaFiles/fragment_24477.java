package com.stackoverflow.q2439984;

import java.io.File;
import java.util.Iterator;

import ca.beq.util.win32.registry.RegistryKey;
import ca.beq.util.win32.registry.RootKey;

public class Test {

    public static void main(String... args) throws Exception {
        RegistryKey.initialize(Test.class.getResource("jRegistryKey.dll").getFile());
        RegistryKey key = new RegistryKey(RootKey.HKLM, "Software\\Mozilla");
        for (Iterator<RegistryKey> subkeys = key.subkeys(); subkeys.hasNext();) {
            RegistryKey subkey = subkeys.next();
            System.out.println(subkey.getName()); // You need to check here if there's anything which matches "Mozilla FireFox".
        }
    }

}