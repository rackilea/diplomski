for (CipherSuite suite : allowedCipherSuites) {
           /* snip */

            if (suite.isAvailable() &&
                    suite.obsoleted > protocols.min.v &&
                    suite.supported <= protocols.max.v) {
              /* snip */
            } else if (debug != null &&
                    Debug.isOn("sslctx") && Debug.isOn("verbose")) {
                if (suite.obsoleted <= protocols.min.v) {
                    System.out.println(
                        "Ignoring obsoleted cipher suite: " + suite);
                } else if (suite.supported > protocols.max.v) {
                    System.out.println(
                        "Ignoring unsupported cipher suite: " + suite);
                } else {
                    System.out.println(
                        "Ignoring unavailable cipher suite: " + suite);
                }
            }
        }