getSecuritySettings().setUnauthorizedComponentInstantiationListener(
            new IUnauthorizedComponentInstantiationListener() {
                public void onUnauthorizedInstantiation(final Component component) {
                    if (component instanceof Page) {
                        // Redirect to index
                        if (component instanceof AdminPage) {
                            redirectionPage = ((AdminPage) component);
                        } else if (component instanceof BalancerPage) {
                            redirectionPage = ((UserPage) component);
                        }
                        throw new RestartResponseAtInterceptPageException(LoginPage.class);
                        // Or you can just throw the original UnauthorizedInstantiationException
                    } else {
                        component.setVisible(false);
                    }
                }
            });