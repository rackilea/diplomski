myWidget.addAttachHandler(new Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                if (event.isAttached()) {
                   $(".choice_span").bind(Event.ONMOUSEUP, ...);
                } else {
                   $(".choice_span").bind(Event.ONMOUSEUP);
                }
            }
        });