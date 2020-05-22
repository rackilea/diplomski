/**
 * Abstract base class for {@link VerticalResizePanel}.
 */
abstract class ResizePanel extends Panel implements HasResizeHandlers {

    /* **************************************** */
    // Private Static Fields
    /* **************************************** */
    /**
     * The element that masks the screen so we can catch mouse events over
     * iframes.
     */
    private static Element glassElem = null;

    /** The handler manager for our events. */

    /* **************************************** */
    // Private Fields
    /* **************************************** */
    // The elements containing the widgets.
    /** The elements. */
    private final Element[] elements = new Element[1];

    /** The handler manager for our events. */

    private final EventBus resizeHandlerManager = new SimpleEventBus();

    // Indicates whether drag resizing is active.
    /** The is resizing. */
    private boolean isResizing = false;

    // The element that acts as the splitter.
    /** The split elem. */
    private final Element splitElem;

    // The enclosed widgets.
    /** The widgets. */
    private final Widget[] widgets = new Widget[2];

    /* **************************************** */
    // Constructors
    /* **************************************** */
    /**
     * Initializes the split panel.
     * 
     * @param mainElem
     *            the root element for the split panel
     * @param splitElem
     *            the element that acts as the splitter
     * @param headElem
     *            the element to contain the top or left most widget
     */
    ResizePanel(final Element mainElem, final Element splitElem,final Element headElem) {
        this.setElement(mainElem);
        this.splitElem = splitElem;
        this.elements[0] = headElem;
        this.sinkEvents(Event.MOUSEEVENTS | Event.ONLOSECAPTURE | Event.TOUCHEVENTS | Event.ONTOUCHCANCEL);
        if (ResizePanel.glassElem == null) {
            ResizePanel.glassElem = DOM.createDiv();
            ResizePanel.glassElem.getStyle()
                    .setProperty("position", "absolute");
            ResizePanel.glassElem.getStyle().setProperty("top", "0px");
            ResizePanel.glassElem.getStyle().setProperty("left", "0px");
            ResizePanel.glassElem.getStyle().setProperty("margin", "0px");
            ResizePanel.glassElem.getStyle().setProperty("padding", "0px");
            ResizePanel.glassElem.getStyle().setProperty("border", "0px");
            // We need to set the background color or mouse events will go right
            // through the glassElem. If the SplitPanel contains an iframe, the
            // iframe will capture the event and the slider will stop moving.
            ResizePanel.glassElem.getStyle().setProperty("background", "white");
            ResizePanel.glassElem.getStyle().setProperty("opacity", "0.0");
            ResizePanel.glassElem.getStyle().setProperty("filter",
                    "alpha(opacity=0)");
            ResizePanel.glassElem.setId("glassElementId");
        }
    }

    /* **************************************** */
    // Package Static Properties
    /* **************************************** */
    /**
     * Returns the offsetHeight element property.
     * 
     * @param elem
     *            the element
     * @return the offsetHeight property
     */
    static final int getOffsetHeight(final Element elem) {
        return DOM.getElementPropertyInt(elem, "offsetHeight");
    }

    /**
     * Returns the offsetWidth element property.
     * 
     * @param elem
     *            the element
     * @return the offsetWidth property
     */
    static final int getOffsetWidth(final Element elem) {
        return DOM.getElementPropertyInt(elem, "offsetWidth");
    }

    /**
     * Adds zero or none CSS values for padding, margin and border to prevent
     * stylesheet overrides. Returns the element for convenience to support
     * builder pattern.
     * 
     * @param elem
     *            the element
     * @return the element
     */
    static final Element preventBoxStyles(final Element elem) {
        DOM.setIntStyleAttribute(elem, "padding", 0);
        DOM.setIntStyleAttribute(elem, "margin", 0);
        DOM.setStyleAttribute(elem, "border", "none");
        return elem;
    }

    /**
     * Convenience method to set bottom offset of an element.
     * 
     * @param elem
     *            the element
     * @param size
     *            a CSS length value for bottom
     */
    static void setBottom(final Element elem, final String size) {
        DOM.setStyleAttribute(elem, "bottom", size);
    }

    /**
     * Sets the elements css class name.
     * 
     * @param elem
     *            the element
     * @param className
     *            the class name
     */
    static final void setClassname(final Element elem, final String className) {
        DOM.setElementProperty(elem, "className", className);
    }

    /**
     * Convenience method to set the height of an element.
     * 
     * @param elem
     *            the element
     * @param height
     *            a CSS length value for the height
     */
    static final void setHeight(final Element elem, final String height) {
        DOM.setStyleAttribute(elem, "height", height);
    }

    /**
     * Convenience method to set the left offset of an element.
     * 
     * @param elem
     *            the element
     * @param left
     *            a CSS length value for left
     */
    static final void setLeft(final Element elem, final String left) {
        DOM.setStyleAttribute(elem, "left", left);
    }

    /**
     * Convenience method to set the right offset of an element.
     * 
     * @param elem
     *            the element
     * @param right
     *            a CSS length value for right
     */
    static final void setRight(final Element elem, final String right) {
        DOM.setStyleAttribute(elem, "right", right);
    }

    /**
     * Convenience method to set the top offset of an element.
     * 
     * @param elem
     *            the element
     * @param top
     *            a CSS length value for top
     */
    static final void setTop(final Element elem, final String top) {
        DOM.setStyleAttribute(elem, "top", top);
    }

    /**
     * Convenience method to set the width of an element.
     * 
     * @param elem
     *            the element
     * @param width
     *            a CSS length value for the width
     */
    static final void setWidth(final Element elem, final String width) {
        DOM.setStyleAttribute(elem, "width", width);
    }

    /* **************************************** */
    // Public Properties
    /* **************************************** */
    /**
     * Gets the element that is acting as the splitter.
     * 
     * @return the element
     */
    public Element getSplitElement() {
        return this.splitElem;
    }

    /**
     * Gets the value of resizeHandlerManager.
     * 
     * @return Gets the value of resizeHandlerManager.
     */
    public EventBus getResizeHandlerManager() {
        return resizeHandlerManager;
    }

    /**
     * Indicates whether the split panel is being resized.
     * 
     * @return if the user is dragging the splitter, otherwise
     */
    public boolean isResizing() {
        return this.isResizing;
    }

    /* **************************************** */
    // Public Static Methods
    /* **************************************** */
    /**
     * Sets an elements positioning to absolute.
     * 
     * @param elem
     *            the element
     */
    static void addAbsolutePositoning(final Element elem) {
        DOM.setStyleAttribute(elem, "position", "absolute");
    }

    /**
     * Adds clipping to an element.
     * 
     * @param elem
     *            the element
     */
    static final void addClipping(final Element elem) {
        DOM.setStyleAttribute(elem, "overflow", "hidden");
    }

    /**
     * Adds as-needed scrolling to an element.
     * 
     * @param elem
     *            the element
     */
    static final void addScrolling(final Element elem) {
        DOM.setStyleAttribute(elem, "overflow", "auto");
    }

    /**
     * Sizes and element to consume the full area of its parent using the CSS
     * properties left, right, top, and bottom. This method is used for all
     * browsers except IE6/7.
     * 
     * @param elem
     *            the element
     */
    static final void expandToFitParentUsingCssOffsets(final Element elem) {
        final String zeroSize = "0px";
        ResizePanel.addAbsolutePositoning(elem);
        ResizePanel.setLeft(elem, zeroSize);
        ResizePanel.setRight(elem, zeroSize);
        ResizePanel.setTop(elem, zeroSize);
        ResizePanel.setBottom(elem, zeroSize);
    }

    /**
     * Sizes an element to consume the full areas of its parent using 100% width
     * and height. This method is used on IE6/7 where CSS offsets don't work
     * reliably.
     * 
     * @param elem
     *            the element
     */
    static final void expandToFitParentUsingPercentages(final Element elem) {
        final String zeroSize = "0px";
        final String fullSize = "100%";
        ResizePanel.addAbsolutePositoning(elem);
        ResizePanel.setTop(elem, zeroSize);
        ResizePanel.setLeft(elem, zeroSize);
        ResizePanel.setWidth(elem, fullSize);
        ResizePanel.setHeight(elem, fullSize);
    }

    /* **************************************** */
    // Public Methods
    /* **************************************** */
    /** {@inheritDoc} */
    @Override
    public void add(final Widget widget) {
        boolean canAddWidget = false;
        for (int index = 0; index < this.widgets.length; index++) {
            if (this.getWidget(index) == null) {
                this.setWidget(index, widget);
                canAddWidget = true;
                break;
            }
        }

        if (!canAddWidget) {
            throw new IllegalStateException(
                    "A Resizable panel can only contain two Widgets.");
        }
    }

    /** {@inheritDoc} */
    public HandlerRegistration addResizeHandler(final ResizeEventHandler handler) {
        return this.resizeHandlerManager.addHandler(ResizeEvent.TYPE, handler);
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<Widget> iterator() {
        return ResizableControlIterator
                .createWidgetIterator(this, this.widgets);
    }

    /** {@inheritDoc} */
    @Override
    public void onBrowserEvent(final Event event) {
        switch (DOM.eventGetType(event)) {
        case Event.ONMOUSEDOWN:
            final Element target = DOM.eventGetTarget(event);
            if (DOM.isOrHasChild(this.splitElem, target)) {
                this.startResizingFrom(DOM.eventGetClientX(event) - this.getAbsoluteLeft(),DOM.eventGetClientY(event) - this.getAbsoluteTop());
                DOM.setCapture(this.getElement());
                DOM.eventPreventDefault(event);
            }
            break;
        case Event.ONMOUSEUP:
            if (this.isResizing()) {
                // The order of these two lines is important. If we release
                // capture
                // first, then we might trigger an onLoseCapture event
                // before we set
                // isResizing to false.
                DOM.releaseCapture(this.getElement());
                this.splitPositionSetDone();
                if (this.isResizing()) {
                    this.stopResizing();
                }
            }
            break;
        case Event.ONMOUSEMOVE:
            if (this.isResizing()) {
                assert DOM.getCaptureElement() != null;
                this.onSplitterResize(DOM.eventGetClientX(event) - this.getAbsoluteLeft(),DOM.eventGetClientY(event) - this.getAbsoluteTop());
                DOM.eventPreventDefault(event);
            }
            break;
        // IE automatically releases capture if the user switches
        // windows, so we
        // need to catch the event and stop resizing.
        case Event.ONLOSECAPTURE:
            if (this.isResizing()) {
                this.stopResizing();
            }
            break;      
        case Event.ONTOUCHSTART:
            final Element touchableTarget = DOM.eventGetTarget(event);          
            if (DOM.isOrHasChild(this.splitElem, touchableTarget)) {
                this.startResizingFrom((event.getTouches().get(0).getClientX() - this.getAbsoluteLeft()),(event.getTouches().get(0).getClientY() - this.getAbsoluteTop()));
                DOM.setCapture(this.getElement());
                event.preventDefault();
            }
            break;
        case Event.ONTOUCHMOVE:
            if (this.isResizing()) {
                assert DOM.getCaptureElement() != null;
                this.onSplitterResize((event.getTouches().get(0).getClientX() - this.getAbsoluteLeft()),(event.getTouches().get(0).getClientY() - this.getAbsoluteTop()));
                event.preventDefault();
            }
            break;
        // IE automatically releases capture if the user switches
        // windows, so we
        // need to catch the event and stop resizing.
        case Event.ONTOUCHEND:
            if (this.isResizing()) {
                // The order of these two lines is important. If we release
                // capture
                // first, then we might trigger an onLoseCapture event
                // before we set
                // isResizing to false.
                DOM.releaseCapture(this.getElement());
                this.splitPositionSetDone();
                if (this.isResizing()) {
                    this.stopResizing();
                }
            }
            break;
        case Event.ONTOUCHCANCEL:
            if (this.isResizing()) {
                this.stopResizing();
            }
            break;
        default:
            break;
        }
        super.onBrowserEvent(event);
    }

    /** {@inheritDoc} */
    @Override
    public boolean remove(final Widget widget) {
        if (widget != null) {
            for (int index = 0; index < this.widgets.length; index++) {
                if ((this.widgets[index] == widget)) {
                    this.setWidget(index, null);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Moves the position of the splitter.
     * 
     * @param size
     *            the new size of the left region in CSS units (e.g. "10px",
     *            "1em")
     */
    public abstract void setSplitPosition(String size);

    /**
     * Split position set done.
     * 
     */
    public abstract void splitPositionSetDone();

    /**
     * Called on each mouse drag event as the user is dragging the splitter.
     * 
     * @param x
     *            the x coordinate of the mouse relative to the panel's extent
     * @param y
     *            the y coordinate of the mouse relative to the panel's extent
     */
    abstract void onSplitterResize(int x, int y);

    /**
     * Called when the user starts dragging the splitter.
     * 
     * @param x
     *            the x coordinate of the mouse relative to the panel's extent
     * @param y
     *            the y coordinate of the mouse relative to the panel's extent
     */
    abstract void onSplitterResizeStarted(int x, int y);

    /* **************************************** */
    // Protected Methods
    /* **************************************** */
    /**
     * Gets the content element for the given index.
     * 
     * @param index
     *            the index of the element, only 0 and 1 are valid.
     * @return the element
     */
    protected Element getElement(final int index) {
        return this.elements[index];
    }

    /**
     * Gets one of the contained widgets.
     * 
     * @param index
     *            the index of the widget, only 0 and 1 are valid.
     * @return the widget
     */
    protected Widget getWidget(final int index) {
        return this.widgets[index];
    }

    /**
     * <b>Affected Elements:</b>
     * <ul>
     * <li>-splitter = the container containing the splitter element.</li>
     * </ul>
     * 
     * @param baseId
     *            The base id.
     * @see UIObject#onEnsureDebugId(String)
     */
    @Override
    protected void onEnsureDebugId(final String baseId) {
        super.onEnsureDebugId(baseId);
        UIObject.ensureDebugId(this.splitElem, baseId, "splitter");
    }

    /**
     * Sets one of the contained widgets.
     * 
     * @param index
     *            the index, only 0 and 1 are valid
     * @param widget
     *            the widget
     */
    protected final void setWidget(final int index, final Widget widget) {
        final Widget oldWidget = this.widgets[index];
        // Validate.
        if (oldWidget == widget) {
            return;
        }
        // Detach the new child.
        if (widget != null) {
            widget.removeFromParent();
        }
        // Remove the old child.
        if (oldWidget != null) {
            // Orphan old.
            try {
                this.orphan(oldWidget);
            } finally {
                // Physical detach old.
                DOM.removeChild(this.elements[0], oldWidget.getElement());
                this.widgets[index] = null;
            }
        }
        // Logical attach new.
        this.widgets[index] = widget;
        if (widget != null) {
            // Physical attach new.
            DOM.appendChild(this.elements[0], widget.getElement());
            // Adopt new.
            this.adopt(widget);
        }
    }

    /* **************************************** */
    // Private Methods
    /* **************************************** */
    /**
     * Start resizing from.
     * 
     * @param x
     *            the x coordinate of the mouse relative to the panel's extent
     * @param y
     *            the y coordinate of the mouse relative to the panel's extent
     */
    public void startResizingFrom(final int x, final int y) {
        this.isResizing = true;
        this.onSplitterResizeStarted(x, y);
        // Resize glassElem to take up the entire scrollable window area
        final int height = RootPanel.getBodyElement().getScrollHeight() - 1;
        final int width = RootPanel.getBodyElement().getScrollWidth() - 1;
        ResizePanel.glassElem.getStyle().setProperty("height", height + "px");
        ResizePanel.glassElem.getStyle().setProperty("width", width + "px");
        RootPanel.getBodyElement().appendChild(ResizePanel.glassElem);
    }

    /**
     * Stop resizing.
     */
    void stopResizing() {
        this.isResizing = false;
        // FIXME:: Why is the remove causing error.
        try {
            RootPanel.getBodyElement().removeChild(ResizePanel.glassElem);
        } catch (final Exception e) {
            GWT.log("Got error removing the glassElem: " + e);
        }
    }
}