/**
     * This piece of code takes care of revealing page on browser refresh event.
     * On browser refresh somehow visibility of page is set to false, so, we need to manually fire the reveal content event.
     */
    if(this.getProxy().canReveal() == true && !this.isVisible()){
                revealInParent();
    }