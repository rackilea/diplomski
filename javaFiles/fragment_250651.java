package bestsss.util;

import java.util.Random;

public class Bitz {
    final int[] array;
    private Bitz(int n){
        array=new int[n<<2];
    }

    public int size(){
        return size(this.array);
    }

    private static int size(int[] array){
        return array.length>>2;
    }
    /**
     * allocates N 128bit elements. newIdx to create a pointer
     * @param n
     * @return
     */
    public static Bitz allocate(int n){
        return new Bitz(n);
    }
    /**
     * Main utility class - points to an index in the array
     * @param idx
     * @return
     */
    public Idx newIdx(int idx){     
        return new Idx(array).set(idx);
    }

    public static class Idx{
        private static final  long mask = 0xFFFFFFFFL;
        //dont make the field finals

        int idx;
        int[] array;//keep ref. here, reduce the indirection

        Idx(int[] array){
            this.array=array;
        }

        public Idx set(int idx) {
            if (Bitz.size(array)<=idx || idx<0)
                throw new IndexOutOfBoundsException(String.valueOf(idx));

            this.idx = idx<<2;
            return this;
        }

        public int index(){
            return idx>>2;
        }

        public Idx shl32(){
            final int[] array=this.array;
            int idx = this.idx;

            array[idx]=array[++idx];
            array[idx]=array[++idx];
            array[idx]=array[++idx];                 
            array[idx]=0;

            return this;
        }

        public Idx shr32(){
            final int[] array=this.array;
            int idx = this.idx+3;

            array[idx]=array[--idx];
            array[idx]=array[--idx];
            array[idx]=array[--idx];                 
            array[idx]=0;
            return this;
        }
        public Idx or(Idx src){         
            final int[] array=this.array;
            int idx = this.idx;

            int idx2 = src.idx;
            final int[] array2=src.array;

            array[idx++]|=array2[idx2++];
            array[idx++]|=array2[idx2++];
            array[idx++]|=array2[idx2++];
            array[idx++]|=array2[idx2++];

            return this;            
        }

        public Idx xor(Idx src){            
            final int[] array=this.array;
            int idx = this.idx;

            int idx2 = src.idx;
            final int[] array2=src.array;

            array[idx++]^=array2[idx2++];
            array[idx++]^=array2[idx2++];
            array[idx++]^=array2[idx2++];
            array[idx++]^=array2[idx2++];

            return this;            
        }

        public Idx add(Idx src){            
            final int[] array=this.array;
            int idx = this.idx+3;

            final int[] array2=src.array;
            int idx2 = src.idx+3;


            long l =0;

            l += array[idx]&mask;
            l += array2[idx2--]&mask;           
            array[idx--]=(int)(l&mask);
            l>>>=32;


            l += array[idx]&mask;
            l += array2[idx2--]&mask;           
            array[idx--]=(int)(l&mask);
            l>>>=32;

            l += array[idx]&mask;
            l += array2[idx2--]&mask;           
            array[idx--]=(int)(l&mask);
            l>>>=32;

            l += array[idx]&mask;
            l += array2[idx2--];            
            array[idx]=(int)(l&mask);
//          l>>>=32;

            return this;            
        }

        public Idx set(long high, long low){
            final int[] array=this.array;
            int idx = this.idx;
            array[idx+0]=(int) ((high>>>32)&mask);
            array[idx+1]=(int) ((high>>>0)&mask);


            array[idx+2]=(int) ((low>>>32)&mask);
            array[idx+3]=(int) ((low>>>0)&mask);
            return this;
        }


        public long high(){
            final int[] array=this.array;
            int idx = this.idx;
            long res = (array[idx]&mask)<<32 | (array[idx+1]&mask); 
            return res;
        }

        public long low(){
            final int[] array=this.array;
            int idx = this.idx;
            long res = (array[idx+2]&mask)<<32 | (array[idx+3]&mask); 
            return res;
        }

        //ineffective but well
        public String toString(){                   
            return String.format("%016x-%016x", high(), low());
        }
    }

    public static void main(String[] args) {
        Bitz bitz = Bitz.allocate(256);
        Bitz.Idx idx = bitz.newIdx(0);
        Bitz.Idx idx2 = bitz.newIdx(2);

        System.out.println(idx.set(0, 0xf));
        System.out.println(idx2.set(0, Long.MIN_VALUE).xor(idx));       

        System.out.println(idx.set(0, Long.MAX_VALUE).add(idx2.set(0, 1)));
        System.out.println("==");
        System.out.println(idx.add(idx));//can add itself

        System.out.println(idx.shl32());//left
        System.out.println(idx.shr32());//and right
        System.out.println(idx.shl32());//back left

        //w/ alloc
        System.out.println(idx.add(bitz.newIdx(4).set(0, Long.MAX_VALUE)));

        //self xor
        System.out.println(idx.xor(idx));
        //random xor

        System.out.println("===init random===");
        Random r = new Random(1112); 
        for (int i=0, s=bitz.size(); i<s; i++){
            idx.set(i).set(r.nextLong(), r.nextLong());
            System.out.println(idx);
        }
        Idx theXor = bitz.newIdx(0);
        for (int i=1, s=bitz.size(); i<s; i++){         
            theXor.xor(idx.set(i));
        }

        System.out.println("===XOR===");
        System.out.println(theXor);
    }
}