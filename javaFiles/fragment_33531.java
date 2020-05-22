webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
                @Override
                public void changed( ObservableValue<? extends State> ov, State oldState, State newState) {
                    if (newState == State.SUCCEEDED) {
                        JSObject jsobj = (JSObject) webEngine.executeScript("window");
                        jsobj.setMember("myApp", moduleSimMain);
                        }
                    }
                });