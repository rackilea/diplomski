boolean b = true;
while (true) {
    b = !b;
    // Check if we got interrupted.
    if(Thread.interrupted()) {
        break; // Break out of the loop.
    }
}