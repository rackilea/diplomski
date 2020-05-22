//randomly choose element
int index = (int) (Math.random() * aSize);
int dataFromA = a[index];

//"remove" it from A
aSize--;
for(int i = index; i<aSize; i++) {
    a[i] = a[i+1];
}

//"add" it to b
b[bSize] = dataFromA;
bSize++;