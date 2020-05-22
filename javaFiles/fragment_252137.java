static {
    java.security.AccessController.doPrivileged(
                      new java.security.PrivilegedAction() {
        public Object run() {
            System.loadLibrary("awt");

            /*
             * Note: The MToolkit object depends on the static initializer
             * of X11GraphicsEnvironment to initialize the connection to
             * the X11 server.
             */
            if (!isHeadless()) {
                // first check the OGL system property
                boolean glxRequested = false;
                String prop = System.getProperty("sun.java2d.opengl");
                if (prop != null) {
                    if (prop.equals("true") || prop.equals("t")) {
                        glxRequested = true;
                    } else if (prop.equals("True") || prop.equals("T")) {
                        glxRequested = true;
                        glxVerbose = true;
                    }
                }

                // Now check for XRender system property
                boolean xRenderRequested = true;
                boolean xRenderIgnoreLinuxVersion = false;
                String xProp = System.getProperty("sun.java2d.xrender");
                    if (xProp != null) {
                    if (xProp.equals("false") || xProp.equals("f")) {
                        xRenderRequested = false;
                    } else if (xProp.equals("True") || xProp.equals("T")) {
                        xRenderRequested = true;
                        xRenderVerbose = true;
                    }

                    if(xProp.equalsIgnoreCase("t") || xProp.equalsIgnoreCase("true")) {
                        xRenderIgnoreLinuxVersion = true;
                    }
                }

                // initialize the X11 display connection
                initDisplay(glxRequested);