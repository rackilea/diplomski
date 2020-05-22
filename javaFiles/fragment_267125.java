package com.j2ko.webviewapp;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Base64;
    import android.util.Log;
    import android.view.View;
    import android.webkit.JavascriptInterface;
    import android.webkit.JsResult;
    import android.webkit.ValueCallback;
    import android.webkit.WebChromeClient;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;

    import java.io.InputStream;
    import java.io.StringReader;
    import java.io.StringWriter;

    public class MainActivity extends AppCompatActivity {
        private static final String MAIN_FUNC_FMT = "(function() { %s })()";
        private static final String FUNC_BODY_FMT =
                "var parent = document.loadedgetElementsByTagName('head').item(0);" +
                        "var css = document.createElement('style');" +
                        "css.type = 'text/css';" +
                        "css.innerHTML = %s;" +
                        "parent.appendChild(css);";

        private static final String BASE64_DECODE_FMT = "window.atob('%s')";

        WebView mWebView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mWebView = (WebView) findViewById(R.id.webview);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    //Change it to whatever
                    injectWithEvaluateAndInterface(view);
                }

                @Override
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                }
            });
            mWebView.setVisibility(View.INVISIBLE);
            mWebView.loadUrl("http://wiki.org");
        }


        private static class CSSInjectBuilder {
            private final String mOrigin;
            private String mAtEnd = null;
            private boolean mUseBase64 = false;

            public CSSInjectBuilder(String css) {
                mOrigin = css;
            }

            public CSSInjectBuilder withBase64() {
                mUseBase64 = true;
                return this;
            }

            public CSSInjectBuilder withExpressionAtEnd(String expression){
                mAtEnd = expression;
                return this;
            }

            String build() {
                String func_body = FUNC_BODY_FMT;

                if (mAtEnd != null) {
                    func_body += mAtEnd;
                }

                final String css;
                if (mUseBase64) {
                    byte[] buffer = mOrigin.getBytes();
                    css = String.format(BASE64_DECODE_FMT, Base64.encodeToString(buffer, Base64.NO_WRAP));
                } else {
                    css = "'" + mOrigin + "'";
                }

                func_body = String.format(func_body, css);

                return String.format(MAIN_FUNC_FMT, func_body);
            }
        }

        byte[] loadAsset() {
            try {
                InputStream inputStream = getAssets().open("style.css");
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                inputStream.close();
                return buffer;
            } catch (Exception e) {
            }

            return null;
        }

        String loadCSS() {
            return new String(loadAsset());
        }

        void injectWithEvaluate(final WebView view) {
            view.evaluateJavascript(new CSSInjectBuilder(loadCSS()).withBase64().build(), new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    view.setVisibility(View.VISIBLE);
                }
            });
        }

        void injectWithEvaluateAndInterface(WebView view) {
            view.addJavascriptInterface(new WebViewInterface(), "WebViewBackEnd");
            final String injector = new CSSInjectBuilder(loadCSS())
                    .withBase64()
                    .withExpressionAtEnd("window.WebViewBackEnd.CSSInjectionComplete();")
                    .build();

            view.evaluateJavascript(injector, null);
        }

        void injectWithLoadUrlSimple(WebView view) {
            view.loadUrl("javascript:" + loadCSS());
            view.setVisibility(View.VISIBLE);
        }

        void injectWithLoadUrlAndCheckAlert(final WebView view) {
            view.setWebChromeClient(new WebChromeClient() {
                @Override
                public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                    if (message.equals("CSSInjectionComplete")) {
                        view.setVisibility(View.VISIBLE);
                        return true;
                    }
                    return super.onJsAlert(view, url, message, result);
                }
            });

            //alert could hang aplying scripts so put it on timeout
            final String injector = new CSSInjectBuilder(loadCSS())
                    .withBase64()
                    .withExpressionAtEnd("setTimeout(function(){alert('CSSInjectionComplete');}, 1);")
                    .build();

            view.loadUrl("javascript:"  + injector);
        }

        private class WebViewInterface {

            @JavascriptInterface
            public void CSSInjectionComplete(){

                mWebView.post(new Runnable() {
                    @Override
                    public void run() {
                        mWebView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }

    }