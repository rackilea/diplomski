package com.custsoft.client;

/**
 * Holds the client ID in the current thread. It is
 * generally placed there by a REST filter that reads
 * it from a "client" HTTP header.
 *
 * Created by eric on 8/25/15.
 */
public class ClientXrefHolder {

    private static final ThreadLocal<String> CLIENT_XREF_HOLDER = new ThreadLocal<>();

    public static String getClientXref() {
        return CLIENT_XREF_HOLDER.get();
    }

    public static void setClientXref(final String clientXref) {
        CLIENT_XREF_HOLDER.set(clientXref);
    }
}