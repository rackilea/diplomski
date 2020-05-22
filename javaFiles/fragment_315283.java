CGDirectDisplayID ids[20];
uint32_t num_ids;
if (kCGErrorSuccess != CGGetActiveDisplayList(20, ids, &num_ids)) {
    printf("Oops\n");
    return 1;
}
boolean_t asleep = true;
for (int i = 0; i < num_ids; i++) {
    asleep &= CGDisplayIsAsleep(ids[i]);
}
if (asleep) {
    printf("Asleep\n");
    return 1;
} else {
    printf("Awake\n");
    return 0;
}