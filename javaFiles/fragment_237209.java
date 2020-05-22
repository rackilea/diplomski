package com.inlet.plugin;

import org.pf4j.ExtensionPoint;

public interface InletFetchReaper extends ExtensionPoint {
    void reap();
}