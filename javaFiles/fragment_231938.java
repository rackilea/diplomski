@SuppressWarnings("unchecked")
public Array(int L, int H) {
    this.array =  (T[]) (new Object[H- L+1]);
    this.l = L;
    this.h = H;
}