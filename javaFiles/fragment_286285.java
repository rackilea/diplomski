309         // First, check if the class has already been loaded
310         Class c = findLoadedClass(name);
311         if (c == null) {
312             try {
313                 if (parent != null) {
314                     c = parent.loadClass(name, false);
315                 } else {
316                     c = findBootstrapClass0(name);
317                 }
318             } catch (ClassNotFoundException e) {
319                 // If still not found, then invoke findClass in order
320                 // to find the class.
321                 c = findClass(name);
322             }
323         }