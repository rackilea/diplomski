interface FasterArrayOfX {
    double getA(int index);
    double getB(int index);
    double getC(int index);
};

class FasterContiguousArrayOfX extends ContiguousArrayOfX implements FasterArrayOfX {
   // Exercise left to the reader
};