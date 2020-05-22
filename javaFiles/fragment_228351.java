boolean always = true;
    while (always) {
        break;
    } // compiles fine!

    // always is still in scope after the loop!
    always = !always;