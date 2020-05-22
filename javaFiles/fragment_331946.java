instruction 'Import-Package',
                // Temporarily support JTA 1.1 -- Karaf and other frameworks still
                // use it.  Without this, the plugin generates [1.2,2).
                'javax.transaction;version="[1.1,2)"',
                // Tell Gradle OSGi to still dynamically import the other packages.
                // IMPORTANT: Do not include the * in the modules' .gradle files.
                // If it exists more than once, the manifest will physically contain a *.
                '*'