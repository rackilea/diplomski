String[] cmd = {
                            "sh",
                            "-c",
                            "python",
                            "/Users/rasheenruwisha/final-year-proj/build.py",
                            "ARG 1",
                            "ARG 2",
                        };
                        try {
                                Runtime.getRuntime().exec(cmd);
                             } catch (IOException e) {
                                e.printStackTrace();
                             }