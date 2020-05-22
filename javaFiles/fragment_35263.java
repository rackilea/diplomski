StringBuilder a = new StringBuilder();
    StringBuilder b = new StringBuilder();
    boolean L1 = false;

    for (char ch: line.toCharArray()){
    ch = L1Stack.peek();
    if (ch == 'A'){
        a.append(L1Stack.pop());
    }
    else if (ch =='B'){
        b.append(L1Stack.pop());
    } else {
       return false;
    }
}
if(a.length() == b.length()){
    L1 = true;
}
return L1;
}