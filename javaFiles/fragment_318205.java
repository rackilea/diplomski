foo(a, b)
{
    final c = a.item;
    new Thread() { 
        @Override
        public void run() {
            bar(c);
        }
    }.start();
    b = a;
    b.count--;
}