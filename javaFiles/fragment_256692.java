while (true){
    if(move(a))
    {
        break;
    }
    else
    {
        continue;
    }
    if(move(b))
    {
        break;
    }
    else
    {
        continue;
    }
}

public boolean move(Parameter parameter){
    if (statement){
        return false;
    }
    else{
        return true;
    }
}