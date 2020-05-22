public class RoiFragment extends AbstractBaseFragment {

        @BindView(R.id.web_roi)
        WebView webViewRoi;
        private String url = FORMS;

        public static RoiFragment newInstance(Bundle bundle) {
            RoiFragment fragment = new RoiFragment();
            if (bundle != null)
                fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getContentView() {
            return R.layout.roi_fragment;
        }


        @Override
        protected void onViewReady(Bundle savedInstanceState) {
            super.onViewReady(savedInstanceState);
            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            for (int i = 0; i < toolbar.getChildCount(); i++) {
                if (i != 0)
                    toolbar.removeViewAt(i);
            }

            Bundle bundle = getArguments();
            if (bundle != null) {
                if (bundle.getInt("FORM") == 1) {
                    url += "roi";
                    toolbar.setTitle(getString(R.string.roi));
                } else if (bundle.getInt("FORM") == 2) {
                    url += "selfassesment";
                    toolbar.setTitle(getString(R.string.self_ass));
                }

            }

            try {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                WebSettings settings = webViewRoi.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setDatabaseEnabled(true);
                String databasePath = getActivity().getDir("database", Context.MODE_PRIVATE).getPath();
                settings.setDatabasePath(databasePath);
                settings.setAppCacheEnabled(true);

                webViewRoi.setWebChromeClient(new WebChromeClient() {
                    @Override
                    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
                                                        long currentQuota, long estimatedSize, long totalUsedQuota,
                                                        WebStorage.QuotaUpdater quotaUpdater) {
                        // try to keep quota size as big as possible else database will not get created in HTML 5 app
                        quotaUpdater.updateQuota(estimatedSize * 2);
                    }
                });
                webViewRoi.setWebViewClient(new WebViewClient());
                JsonObject object = new JsonObject();
                object.addProperty("token", LoginActivity.loginInfoDTO.getToken());
                String outputT = object.toString();

                Gson gson = new Gson();
                String a1 = gson.toJson(LoginActivity.loginInfoDTO.getProfile());


                String auth1 = URLEncoder.encode(a1, "UTF-8");
                String auth2 = URLEncoder.encode(outputT, "UTF-8");

                String a = "Radius.PROFILE=" + auth1;
                String q = "Radius.AUTH=" + auth2;
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                clearcookies(cookieManager);
                cookieManager.setCookie(url, q);
                cookieManager.setCookie(url, a);
                settings.setAllowUniversalAccessFromFileURLs(true);
                settings.setAllowFileAccessFromFileURLs(true);
                settings.setBuiltInZoomControls(true);
                webViewRoi.setWebChromeClient(new WebChromeClient());
                webViewRoi.loadUrl(url);

            } catch (Exception e) {
                Log.e("ROI", "error", e);
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }

        @SuppressWarnings("deprecation")
        void clearcookies(CookieManager cookieManager) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
                cookieManager.removeAllCookies(null);
            else
                cookieManager.removeAllCookie();
        }

    }