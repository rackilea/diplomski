@Override
    public List<WebElement> findElements(By by) {
        String originalContext = getContext();
        if ("NATIVE_APP".equals(originalContext)) {
            originalContext = null; // no need to switch
        } else {
            context("NATIVE_APP");
        }
        try {
            getScreenshot(); // Before screenshot
            return super.findElements(by);
        } finally {                
            if (originalContext!=null) {
                context(originaContext);
            }
        }
    }