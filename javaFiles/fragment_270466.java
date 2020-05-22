else if(in[j]==')'){
    while(!st.empty() ){
        char ch=st.pop().toString().charAt(0);
        if(ch == '(') break;
        out.append(ch);
    }
}