Bundle state1=new Bundle();
webview.saveState(state1);
Bundle state2=new Bundle();
webviewtwo.saveState(state2);
outState.putBundle("state1",state1);
outState.putBundle("state2",state2);
super.onSaveInstanceState(outState);