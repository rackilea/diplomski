package foo;

import java.sql.Date;
import java.util.*;  // import on demand: java.util.Date does not shadow java.sql.Date
import java.awt.*;  // import on demand: java.awt.List does not shadow java.util.List

class Integer { // (foo.)Integer shadows java.lang.Integer
    ...

    static class Integer { // (foo.Integer.)Integer shadows foo.Integer.
        ...

        List t = ... // Compilation error, because there are currently two visible 
                     // declarations of List (JLS 6.5.5.1)
    }
}