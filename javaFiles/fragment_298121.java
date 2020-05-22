private void ensureSelectedTabIsVisible() {
            // work out the visible width of the tab header
            double tabPaneWidth = snapSize(isHorizontal() ? getSkinnable().getWidth() : getSkinnable().getHeight());
            double controlTabWidth = snapSize(controlButtons.getWidth());
            double visibleWidth = tabPaneWidth - controlTabWidth - firstTabIndent() - SPACER;

            // and get where the selected tab is in the header area
            double offset = 0.0;
            double selectedTabOffset = 0.0;
            double selectedTabWidth = 0.0;
            for (Node node : headersRegion.getChildren()) {
                TabHeaderSkin tabHeader = (TabHeaderSkin)node;

                double tabHeaderPrefWidth = snapSize(tabHeader.prefWidth(-1));

                if (selectedTab != null && selectedTab.equals(tabHeader.getTab())) {
                    selectedTabOffset = offset;
                    selectedTabWidth = tabHeaderPrefWidth;
                }
                offset += tabHeaderPrefWidth;
            }

            final double scrollOffset = getScrollOffset();
            final double selectedTabStartX = selectedTabOffset;
            final double selectedTabEndX = selectedTabOffset + selectedTabWidth;

            final double visibleAreaEndX = visibleWidth;

            if (selectedTabStartX < -scrollOffset) {
                setScrollOffset(-selectedTabStartX);
            } else if (selectedTabEndX > (visibleAreaEndX - scrollOffset)) {
                setScrollOffset(visibleAreaEndX - selectedTabEndX);
            }
        }