// This function was overwritten
    private void ensureSelectedTabIsVisible() {
        // work out the visible width of the tab header
        double tabPaneWidth = snapSize(isHorizontal() ? getSkinnable().getWidth() : getSkinnable().getHeight());
        double controlTabWidth = snapSize(controlButtons.getWidth());
        double visibleWidth = tabPaneWidth - controlTabWidth - firstTabIndent() - SPACER;


        // and get where the selected tab is in the header area
        double offset = 0.0;
        double selectedTabOffset = 0.0;
        double selectedTabWidth = 0.0;

        // OVERWRITE
        // Makes the nearby 3 tabs for each side of the selected tab visible.
        ObservableList<Node> headersRegionChildren = headersRegion.getChildren();
        boolean nextTabs = false;
        int nextTabsCount = 0;
        int current = 0;
        int numOfTabsToShowNext = 3;
        int numOfTabsToShowBefore = 3;
        double tabHeaderPrefWidth;       
        TabHeaderSkin tabHeader;

        for (Node node : headersRegionChildren) {
            tabHeader = (TabHeaderSkin)node;

            tabHeaderPrefWidth = snapSize(tabHeader.prefWidth(-1));

           if (selectedTab != null && selectedTab.equals(tabHeader.getTab())) {
                    selectedTabWidth = tabHeaderPrefWidth;

                // OVERWRITE: Finds the offset of the first tab in the limit numOfTabsToShowBefore before the selected one to be shown
                for(int i = current - 1; i >= 0 && numOfTabsToShowBefore > 1; i--, numOfTabsToShowBefore--){
                    tabHeader = (TabHeaderSkin)headersRegionChildren.get(i);
                    tabHeaderPrefWidth = snapSize(tabHeader.prefWidth(-1));
                    offset -= tabHeaderPrefWidth;
                    selectedTabWidth += tabHeaderPrefWidth;
                }

                selectedTabOffset = offset;
                // OVERWRITE: Sets the flag to start counting in the next 3 nearby tabs.  
                nextTabs = true;
            }
            // OVERWRITE: Sums the width of the next nearby tabs with the
            // width of the selected tab, so it will scroll enough to show
            // them too.
            if(nextTabs && nextTabsCount < numOfTabsToShowNext){
                selectedTabWidth += tabHeaderPrefWidth;
                nextTabsCount++;
            }else if(nextTabsCount == numOfTabsToShowNext){
                break;
            }

            offset += tabHeaderPrefWidth;
            current++;
        }
        // END OVERWRITE

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