try {
    mySemaphore.aquire(); // This will hang until there is a vacancy
    do_my_critical_stuff();
} finally {
    mySemaphore.release();
}