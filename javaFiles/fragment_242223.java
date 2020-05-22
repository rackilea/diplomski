public synchronized static A getA(){  
    if (obj == null){  
        obj = new Singleton();//instance will be created at request time  
    }   
    return obj;  
}