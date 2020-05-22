/*
     * I Added restOfTheInts = null; in MyListOfInts Method
     */
    public class MyListOfInts {

        public int firstInt; // contain data
        public MyListOfInts restOfTheInts; // points to next node

        public MyListOfInts(int f){ // constructor 1
            firstInt=f;
            restOfTheInts = null;
        }

        public MyListOfInts(int f, MyListOfInts r){ // constructor 2 implements nodes and data
            firstInt=f;
            restOfTheInts=r;
        }
    }