byte[] res = new byte[len];
Inflater inf = new Inflater();

int a = 0; // number of bytes that have already been obtained
for (int p = 0; p < comp.length; p++) {         
    inf.setInput(comp, p, 1);
    a += inf.inflate(res, a, len - a);
}