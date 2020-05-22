/**
     * Constructs a new WebView with a Context object.
     *
     * @param context a Context object used to access application assets
     */
    public WebView(Context context) {
        this(context, null);
    }

    /**
     * Constructs a new WebView with layout parameters.
     *
     * @param context a Context object used to access application assets
     * @param attrs an AttributeSet passed to our parent
     */
    public WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
    }

    /**
     * Constructs a new WebView with layout parameters and a default style.
     *
     * @param context a Context object used to access application assets
     * @param attrs an AttributeSet passed to our parent
     * @param defStyleAttr an attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     */
    public WebView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * Constructs a new WebView with layout parameters and a default style.
     *
     * @param context a Context object used to access application assets
     * @param attrs an AttributeSet passed to our parent
     * @param defStyleAttr an attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     * @param defStyleRes a resource identifier of a style resource that
     *        supplies default values for the view, used only if
     *        defStyleAttr is 0 or can not be found in the theme. Can be 0
     *        to not look for defaults.
     */
    public WebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr, defStyleRes, null, false);
    }

    /**
     * Constructs a new WebView with layout parameters and a default style.
     *
     * @param context a Context object used to access application assets
     * @param attrs an AttributeSet passed to our parent
     * @param defStyleAttr an attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     * @param privateBrowsing whether this WebView will be initialized in
     *                        private mode
     *
     * @deprecated Private browsing is no longer supported directly via
     * WebView and will be removed in a future release. Prefer using
     * {@link WebSettings}, {@link WebViewDatabase}, {@link CookieManager}
     * and {@link WebStorage} for fine-grained control of privacy data.
     */
    @Deprecated
    public WebView(Context context, AttributeSet attrs, int defStyleAttr,
            boolean privateBrowsing) {
        this(context, attrs, defStyleAttr, 0, null, privateBrowsing);
    }

    /**
     * Constructs a new WebView with layout parameters, a default style and a set
     * of custom Javscript interfaces to be added to this WebView at initialization
     * time. This guarantees that these interfaces will be available when the JS
     * context is initialized.
     *
     * @param context a Context object used to access application assets
     * @param attrs an AttributeSet passed to our parent
     * @param defStyleAttr an attribute in the current theme that contains a
     *        reference to a style resource that supplies default values for
     *        the view. Can be 0 to not look for defaults.
     * @param javaScriptInterfaces a Map of interface names, as keys, and
     *                             object implementing those interfaces, as
     *                             values
     * @param privateBrowsing whether this WebView will be initialized in
     *                        private mode
     * @hide This is used internally by dumprendertree, as it requires the javaScript interfaces to
     *       be added synchronously, before a subsequent loadUrl call takes effect.
     */
    protected WebView(Context context, AttributeSet attrs, int defStyleAttr,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        this(context, attrs, defStyleAttr, 0, javaScriptInterfaces, privateBrowsing);
    }

    /**
     * @hide
     */
    @SuppressWarnings("deprecation")  // for super() call into deprecated base class constructor.
    protected WebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        sEnforceThreadChecking = context.getApplicationInfo().targetSdkVersion >=
                Build.VERSION_CODES.JELLY_BEAN_MR2;
        checkThread();

        ensureProviderCreated();
        mProvider.init(javaScriptInterfaces, privateBrowsing);
        // Post condition of creating a webview is the CookieSyncManager.getInstance() is allowed.
        CookieSyncManager.setGetInstanceIsAllowed();
    }