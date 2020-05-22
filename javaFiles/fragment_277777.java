interface operations<T> {  
    void sum(T t);  
}



class matrix implements operations<matrix> {  
    @Override   
    public void sum(matrix m){  
    } 
}



class vector3D implements operations<vecor3D> {  
    @Override  
    public void sum(vecor3D v){  
    }
}