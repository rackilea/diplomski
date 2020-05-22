new ClassGraph().enableAllInfo()
                    .whitelistPackages("abc1")
                    .whitelistPackages("abc2")
                    .whitelistPackages("java")
                    .enableSystemJarsAndModules()
                    .scan();