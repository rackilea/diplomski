class OverflowException extends RuntimeException {}

public class Variables {
    int[] data;
    int size;

    public Variables(int size_){
        size = size_;
        data = new int[1 + size/32];
    }
    public boolean get(int i){
         return (data[i/32] & (1 << i%32)) != 0;
    }
    public void set(int i, boolean v){
        if (v)
            data[i/32] |= (1 << i%32);
        else
            data[i/32] &= ~(1 << i%32);
    }
    public void increment(){
         int i;
         for (i=0; i < size/32; i++){
             data[i]++;
             if (data[i] != 0) return;
         }
         if (size%32 != 0){
             data[i]++;
             if ((data[i] & ~((1 << (size%32)) - 1)) != 0)
                 throw new OverflowException();
        }
    }
}