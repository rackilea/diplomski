package com;

abstract  class ArrayListClass{
    protected Object [] list;
    protected int maxSize;
    protected int length;

    public ArrayListClass(){
        maxSize = 100;
        length = 0;
        list = new Object [maxSize];
    }
    public ArrayListClass(int size){
        maxSize=size;
        list=new Object [maxSize];
        length=0;
    }


    public boolean isEmpty(){
        return length==0;
    }
    public boolean isFull(){
        if(length==maxSize)
            return true;
        else 
            return false;
    }


    public int listSize(){
        return length;
    }

    public int maxListSize(){
        return maxSize;
    }

    abstract void  print();

    public boolean isItemAtEqual(int location, Object item)
    {
        return (list[location].equals(item));
    }
    public void insertEnd(Object item){
        if(!isFull())
            list[length++] = item;
    }

}  

public class ArrayListClassImpl extends ArrayListClass{

    public ArrayListClassImpl(int i) {
        super(i);
    }

    public void print(){
        System.out.print("The list contains:");
        for(int i = 0; i < length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }

    public static void main(String [] args){
        ArrayListClass dac = new ArrayListClassImpl(5);
        dac.insertEnd(4);
        dac.insertEnd(5);
        dac.insertEnd(6);
        dac.print();
        System.out.println("dac.isItemAtEqual(0,9)"+dac.isItemAtEqual(0,9));
        System.out.println("dac.isItemAtEqual(1,9)"+dac.isItemAtEqual(1,9));
    }
}