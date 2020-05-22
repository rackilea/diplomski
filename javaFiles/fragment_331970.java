@Override
public String toString(){
    if(level == destination)
    return name + id + " on level " + level;

    else
    return name + "(" + id + ")" + " on level " + level + " waiting to go to level " + destination;
}