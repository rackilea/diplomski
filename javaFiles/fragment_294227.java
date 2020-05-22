package za.co.bsg.ems.client.framework.ui.slider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;


/**
 * This widget wraps the JQuery UI Slider and allows for single slider .
 * 
 * All options can be get or set using generic get/setIntOption, get/setStringOption, get/setBooleanOption
 * methods, but some convenience methods are provided for most popular such as
 * setValues and setMinimum and setMaximum.  See SliderOptions for full list of options.
 * @see SliderOption
 *
 */
@SuppressWarnings("Convert2Diamond")
public class SingleSlider extends Widget {

    private JSONObject defaultOptions;
    private List<SliderListener> listeners = new ArrayList<SliderListener>();

    /**
     * Create the default slider with the specified ID.  The ID is required
     * because the slider needs a specific ID to connect to.
     * @param id - id of the element to create
     */
    public SingleSlider(String id) {
        this(id, null);        
    }

    /**
     * Create a slider with the specified ID.  The ID is required
     * because the slider needs a specific ID to connect to.
     * @param id - id of the element to create
     * @param options - JSONObject of any possible option, can be null for defaults
     */
    public SingleSlider(String id, JSONObject options) {
        super();
        Element divEle = DOM.createDiv();
        setElement(divEle);
        divEle.setId(id);

        defaultOptions = options;
        if (defaultOptions == null) {
            defaultOptions = getOptions(0, 100, 0);
        }        
    }

    /**
     * A convenient way to create an options JSONObject.  Use SliderOption for keys.
     * @param min - default minimum of the slider
     * @param max - default maximum of the slider
     * @param defaultValue - default point of anchor
     * @return a JSONObject of Slider options
     */
    public static JSONObject getOptions(int min, int max, int defaultValue) {
        JSONObject options = new JSONObject();
        options.put(SliderOption.MIN.toString(), new JSONNumber(min));
        options.put(SliderOption.MAX.toString(), new JSONNumber(max));
        options.put(SliderOption.VALUE.toString(), new JSONNumber(defaultValue));
        options.put(SliderOption.RANGE.toString(), new JSONString("min"));
        return options;
    }

    @Override
    protected void onLoad() {
        createSliderJS(this, getElement().getId(), defaultOptions.getJavaScriptObject());
        super.onLoad();
    }

    @Override
    protected void onUnload() {
        destroySliderJS(this, getElement().getId());
        super.onUnload();        
    }
    /**
     * Gets the minimum possible value for the slider
     * @return Returns the minimum.
     */
    public int getMinimum() {
        return getIntOptionJS(getElement().getId(), SliderOption.MIN.toString());
    }

    /**
     * Sets the minimum possible value for the slider
     * @param minimum The minimum to set.
     */
    public void setMinimum(int minimum) {
        setIntOptionJS(getElement().getId(), SliderOption.MIN.toString(), minimum);
    }

    /**
     * Gets the maximum possible value for the slider
     * @return Returns the maximum.
     */
    public int getMaximum() {
        return getIntOptionJS(getElement().getId(), SliderOption.MAX.toString());
    }

    /**
     * Sets the maximum possible value for the slider
     * @param maximum The maximum to set.
     */
    public void setMaximum(int maximum) {
        setIntOptionJS(getElement().getId(), SliderOption.MAX.toString(), maximum);
    }

    /**
     * Convenience method for only 1 anchor
     * @param value to set.
     */
    public void setValue(int value) {
        setValueJS(getElement().getId(), value);
    }


    /**
     * Set an option numeric value
     * @param option the SliderOption
     * @param value the numeric
     */
    public void setIntOption(SliderOption option, int value) {
        setIntOptionJS(getElement().getId(), option.toString(), value);
    }

    /**
     * Get an option numeric value
     * @param option the SliderOption
     * @return value the numeric
     */
    public int getIntOption(SliderOption option) {
        return getIntOptionJS(getElement().getId(), option.toString());
    }

    /**
     * Set an option boolean value
     * @param option the SliderOption
     * @param value the boolean
     */
    public void setBooleanOption(SliderOption option, boolean value) {
        setBooleanOptionJS(getElement().getId(), option.toString(), value);
    }

    /**
     * Get an option boolean value
     * @param option the SliderOption
     * @return value the boolean
     */
    public boolean getBooleanOption(SliderOption option) {
        return getBooleanOptionJS(getElement().getId(), option.toString());
    }

    /**
     * Set an option string value
     * @param option the SliderOption
     * @param value the String
     */
    public void setStringOption(SliderOption option, String value) {
        setStringOptionJS(getElement().getId(), option.toString(), value);
    }

    /**
     * Set an option string value
     * @param option the SliderOption
     * @return value the String
     */
    public String setStringOption(SliderOption option) {
        return getStringOptionJS(getElement().getId(), option.toString());
    }

    /**
     * Add a SliderListener
     * @param l - SliderListener
     */
    public void addListener(SliderListener l) {
        listeners.add(l);
    }

    /**
     * Removes the SliderListener
     * @param l - SliderListener
     */
    public void removeListener(SliderListener l) {
        listeners.remove(l);
    }


    private void fireOnStartEvent(Event evt, int value) {
        SliderEvent e = new SliderEvent(evt, this, value);

        for (SliderListener l : listeners) {
            l.onStart(e);
        }
    }

    private boolean fireOnSlideEvent(Event evt, int value) {
        SliderEvent e = new SliderEvent(evt, this, value);

        for (SliderListener l : listeners) {
            l.onStart(e);
        }

        boolean ret = true;

        for (SliderListener l : listeners) {
            if (!l.onSlide(e)) {
                //if any of the listeners returns false, return false,
                //but let them all do their thing
                ret = false;
            }
        }

        return ret;
    }

    private void fireOnChangeEvent(Event evt, int value, boolean hasOriginalEvent) {
        SliderEvent e = new SliderEvent(evt, this, value, hasOriginalEvent);

        for (SliderListener l : listeners) {
            l.onChange(e);
        }
    }

    private void fireOnStopEvent(Event evt, int value) {
        SliderEvent e = new SliderEvent(evt, this, value);

        for (SliderListener l : listeners) {
            l.onStop(e);
        }
    }


    private native void setIntOptionJS(String id, String option, int value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;


    private native int getIntOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;


    private native void setBooleanOptionJS(String id, String option, boolean value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;


    private native boolean getBooleanOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;


    private native void setStringOptionJS(String id, String option, String value) /*-{
        $wnd.$("#" + id).slider("option", option, value);
    }-*/;


    private native String getStringOptionJS(String id, String option) /*-{
        return $wnd.$("#" + id).slider("option", option);
    }-*/;

    private native void setValueJS(String id, int value) /*-{
        $wnd.$("#" + id).slider("option", "value", value);
    }-*/;


    private native void createSliderJS(SingleSlider x, String id, JavaScriptObject options) /*-{
        options.start = function(event, ui) {
            x.@za.co.bsg.ems.client.framework.ui.slider.SingleSlider::fireOnStartEvent(Lcom/google/gwt/user/client/Event;I)(event, ui.value);
        };
        options.slide = function(event, ui) {
            return x.@za.co.bsg.ems.client.framework.ui.slider.SingleSlider::fireOnSlideEvent(Lcom/google/gwt/user/client/Event;I)(event, ui.value);
        };
        options.change = function(event, ui) {
            var has = event.originalEvent ? true : false;
            x.@za.co.bsg.ems.client.framework.ui.slider.SingleSlider::fireOnChangeEvent(Lcom/google/gwt/user/client/Event;IZ)(event, ui.value, has);
        };
        options.stop = function(event, ui) {
            x.@za.co.bsg.ems.client.framework.ui.slider.SingleSlider::fireOnStopEvent(Lcom/google/gwt/user/client/Event;I)(event, ui.value);
        };

        $wnd.$("#" + id).slider(options);
    }-*/;


    private native void destroySliderJS(SingleSlider x, String id) /*-{
        $wnd.$("#" + id).slider("destroy");
    }-*/;
}