WebView webView = new WebView();
    final WebEngine engine = webView.getEngine();
    engine.load("https://stackoverflow.com/questions/14029964/execute-a-javascript-function-for-a-webview-from-a-javafx-program");

    engine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
                @Override
                public void changed(ObservableValue ov, State oldState, State newState) {
                    if (newState == State.SUCCEEDED) {
                        engine.executeScript(
                                "function highlightWord(root,word){"
                                + "  textNodesUnder(root).forEach(highlightWords);"
                                + ""
                                + "  function textNodesUnder(root){"
                                + "    var n,a=[],w=document.createTreeWalker(root,NodeFilter.SHOW_TEXT,null,false);"
                                + "    while(n=w.nextNode()) a.push(n);"
                                + "    return a;"
                                + "  }"
                                + ""
                                + "  function highlightWords(n){"
                                + "    for (var i; (i=n.nodeValue.indexOf(word,i)) > -1; n=after){"
                                + "      var after = n.splitText(i+word.length);"
                                + "      var highlighted = n.splitText(i);"
                                + "      var span = document.createElement('span');"
                                + "      span.style.backgroundColor='#f00';"
                                + "      span.appendChild(highlighted);"
                                + "      after.parentNode.insertBefore(span,after);"
                                + "    }"
                                + "  }"
                                + "}"
                                + "\n"
                                + "highlightWord(document.body,'function');");
                    }
                }
            });


    Scene scene = new Scene(webView, 500, 500);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();