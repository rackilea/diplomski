public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);

    String url = "http://youtube.com";
    //layout
    myWebView = new VideoEnabledWebView(getActivity());
    myWebView = (VideoEnabledWebView) rootView.findViewById(R.id.webViewTop);
    mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swiperefresh);
    progress = (ProgressBar) rootView.findViewById(R.id.progressBar3);
    View nonVideoLayout = rootView.findViewById(R.id.nonVideoLayout);
    ViewGroup videoLayout = (ViewGroup)rootView.findViewById(R.id.videoLayout);
    View loadingView = getActivity().getLayoutInflater().inflate(R.layout.view_loading_video, null);
webChromeClient = new VideoEnabledWebChromeClient(nonVideoLayout,  videoLayout, loadingView, myWebView)
    {
 public void onProgressChanged(WebView view, int newProgress) {

         progress.setProgress(newProgress);
         progress.setVisibility(View.VISIBLE);
          setRefreshActionButtonState(true);


          if (newProgress == 100) {
           progress.setVisibility(View.GONE);
           setRefreshActionButtonState(false);
              mSwipeRefreshLayout.setRefreshing(false);


             }
           }
         };

webChromeClient.setOnToggledFullscreen(new VideoEnabledWebChromeClient.ToggledFullscreenCallback()
    {
        @Override
        public void toggledFullscreen(boolean fullscreen)
        {
            // Your code to handle the full-screen change, for example showing and hiding the title bar. Example:
            if (fullscreen)
            {

                WindowManager.LayoutParams attrs = getActivity().getWindow().getAttributes();
                attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
                attrs.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                getActivity().getWindow().setAttributes(attrs);
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    //noinspection all
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
                }
            }
            else
            {
                WindowManager.LayoutParams attrs = getActivity().getWindow().getAttributes();
                attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
                attrs.flags &= ~WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                getActivity().getWindow().setAttributes(attrs);
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    //noinspection all
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }
            }

        }
    });
    myWebView.setWebChromeClient(webChromeClient);

  return rootview;}