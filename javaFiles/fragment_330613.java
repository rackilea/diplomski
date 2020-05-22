package com.example.q45897574;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class RestrictiveClassLoader extends URLClassLoader {

    private static final Pattern COMMON_SYSTEM_RESOURCE_NAMES = Pattern
            .compile("(((net\\.)?java)|(java(x)?)|(sun|oracle))\\.[a-zA-Z0-9\\.\\-_\\$\\.]+");
    private static final String OWN_CLASS_NAME = RestrictiveClassLoader.class.getName();
    private static final URL[] EMPTY_URL_ARRAY = new URL[0], CLASSPATH_ENTRY_URLS;
    private static final PermissionCollection NO_PERMS = new Permissions();

    static {
        String[] classpathEntries = AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                return System.getProperty("java.class.path");
            }
        }).split(File.pathSeparator);
        Set<URL> classpathEntryUrls = new LinkedHashSet<>(classpathEntries.length, 1);
        for (String classpathEntry : classpathEntries) {
            try {
                URL classpathEntryUrl;
                if (classpathEntry.endsWith(".jar")) {
                    classpathEntryUrl = new URL("file:jar:".concat(classpathEntry));
                }
                else {
                    if (!classpathEntry.endsWith("/")) {
                        classpathEntry = classpathEntry.concat("/");
                    }
                    classpathEntryUrl = new URL("file:".concat(classpathEntry));
                }
                classpathEntryUrls.add(classpathEntryUrl);
            }
            catch (MalformedURLException mue) {
            }
        }
        CLASSPATH_ENTRY_URLS = classpathEntryUrls.toArray(EMPTY_URL_ARRAY);
    }

    private static byte[] readClassData(URL classResource) throws IOException {
        try (InputStream in = new BufferedInputStream(classResource.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            while (in.available() > 0) {
                out.write(in.read());
            }
            return out.toByteArray();
        }
    }

    public RestrictiveClassLoader(ClassLoader parent) {
        super(EMPTY_URL_ARRAY, parent);
        for (URL classpathEntryUrl : CLASSPATH_ENTRY_URLS) {
            addURL(classpathEntryUrl);
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name == null) {
            throw new ClassNotFoundException("< null >", new NullPointerException("name argument must not be null."));
        }
        if (OWN_CLASS_NAME.equals(name)) {
            return RestrictiveClassLoader.class;
        }
        if (COMMON_SYSTEM_RESOURCE_NAMES.matcher(name).matches()) {
            return getParent().loadClass(name);
        }
        Class<?> ret = findLoadedClass(name);
        if (ret != null) {
            return ret;
        }
        return findClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String modifiedClassName = name.replace(".", "/").concat(".class");
        URL classResource = findResource(modifiedClassName);
        if (classResource == null) {
            throw new ClassNotFoundException(name);
        }
        byte[] classData;
        try {
            classData = readClassData(classResource);
        }
        catch (IOException ioe) {
            throw new ClassNotFoundException(name, ioe);
        }
        return defineClass(name, classData, 0, classData.length, constructClassDomain(classResource));
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        return NO_PERMS;
    }

    private ProtectionDomain constructClassDomain(URL codeSourceLocation) {
        CodeSource cs = new CodeSource(codeSourceLocation, (Certificate[]) null);
        return new ProtectionDomain(cs, getPermissions(cs), this, null);
    }

}