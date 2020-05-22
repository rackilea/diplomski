package com.example.q45897574;

public class A {

    public static void main(String... args) {
        /*
         * Note:
         * > Can't we set the security manager via launch argument?
         * No, it has to be set here, or bootstrapping will fail.
         * > Why?
         * Because our class loader's domain is unprivileged.
         * > Can't it be privileged?
         * Yes, but then everything under the same classpath entry becomes
         * privileged too, because our loader's domain's code source--which
         * _its own_ loader creates, thus escaping our control--implies _the
         * entire_ classpath entry. There are various workarounds, which
         * however fall outside of this example's scope.
         */
        System.setSecurityManager(new SecurityManager());
        B.b();
    }

}