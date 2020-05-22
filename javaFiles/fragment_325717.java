boolean firstValueSeen = false;
int firstValue = -1;

for (…) {
        …
            int transientId = d_idGenerator.getNewId();
            firstValueSeen = true;
            firstValue = transientId