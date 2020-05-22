Sum left  = new Sum(array, low, mid);
Sum right = new Sum(array, mid, high);
left.fork();
long rightAns = right.compute();
long leftAns   = left.join();
return leftAns + rightAns;