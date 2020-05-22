/* Arena-based malloc for compilation tasks */
    void * dvmCompilerNew(size_t size, bool zero)
    {
        /* edit: some code omitted. */
retry:
        /* Normal case - space is available in the current page */
        if (size + currentArena->bytesAllocated <= currentArena->blockSize) {
            void *ptr;
            ptr = &currentArena->ptr[currentArena->bytesAllocated];
            currentArena->bytesAllocated += size;
            /* edit: some code omitted. */
        } else {                                                      // <0>
            /*
             * See if there are previously allocated arena blocks before the last
             * reset
             */
            /* edit: some code omitted. */

            /* Time to allocate a new arena */
            ArenaMemBlock *newArena = (ArenaMemBlock *)
                malloc(sizeof(ArenaMemBlock) + blockSize);           // <1>
            if (newArena == NULL) {
                ALOGE("Arena allocation failure");
                dvmAbort();
            }
            newArena->blockSize = blockSize;
            newArena->bytesAllocated = 0;
            newArena->next = NULL;
            currentArena->next = newArena;                           // <2>
            currentArena = newArena;
            numArenaBlocks++;
            if (numArenaBlocks > 10)
                ALOGI("Total arena pages for JIT: %d", numArenaBlocks);
            goto retry;
        }
        /* edit: some code omitted. */
    }