//Method #1
    if(!(data instanceof Cloneable)){
        throw new RuntimeException("data's class doesn't implement a custom clone method");
    }
    Method cloneMethod = data.getClass().getMethod("clone");
    this.data = cloneMethod.invoke(data);