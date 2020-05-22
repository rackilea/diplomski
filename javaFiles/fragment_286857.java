int mattress = 24;
int mask = 1;
for(int i = 0; i < num_stores; ++i) {
    if(mask & mattress != 0) {
        System.out.println("Store "+i+" has mattresses!");
    }
    mask = mask << 1;
}