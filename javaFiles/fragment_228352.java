for (boolean always = true; always; ) {
        break;
    } // compiles fine!

    // always is no longer declared after the loop!
    always = !always; // DOES NOT COMPILE!