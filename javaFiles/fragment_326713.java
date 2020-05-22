Window.addWindowScrollHandler(new ScrollHandler() {         
            @Override
            public void onWindowScroll(ScrollEvent event) {
                int scrollX = event.getScrollLeft();
                int scrollY = event.getScrollTop();

            }
        });