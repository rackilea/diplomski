/*
 * RubberBandListener.java
 *
 * Created on August 18, 2005, 3:27 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package com.ges.util;

import java.util.EventListener;
import java.awt.Rectangle;

/**
 *
 * @author mstemen
 */
public interface RubberBandListener extends EventListener {

    public abstract void notifyBounds(Rectangle boundingBox);
}