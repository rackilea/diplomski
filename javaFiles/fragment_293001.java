if (Trees < MAX_TREES) {
    Trees += treespersecond;
}
if (Wood < MAX_WOOD && Trees > 0) {
    Trees -= woodpersecond;
    Wood += woodpersecond;
}
if (Cash < MAX_CASH && Wood > 0) {
    Wood -= cashpersecond;
    Cash += cashpersecond;
}