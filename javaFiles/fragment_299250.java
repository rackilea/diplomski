// Warning, untested code!

enum Level {DEBUG, INFO, WARNING, ERROR}

public static Logger logger; // Whereever you get this one...

public static void log(Level level, String s) {
    System.out.println(level.name() + ": " + s);
    switch (level) {
         case INFO:
             logger.info(s);
             break;

         // The other levels...
    }
}