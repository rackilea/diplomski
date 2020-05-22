...

lambda func = x -> 0;

for(int i=0; i < 100; i++){
    final int index = i;
    final lambda finalFunc = func;
    func = x -> finalFunc.apply(x) + index*x;
}