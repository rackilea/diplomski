public class MyThreadA implements Runnable {  
    ThreadResource tR;  

     public MyThreadA(ThreadResource tr) {  
        this.tR = tr;  
    }  
// your run method here NOT declaring a ThreadResource anymore!!!
}