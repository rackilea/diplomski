else if(in[j]==')'){
    int k=j;

    while(in[k]!='(' && !st.empty() ){

        char ch=st.pop().toString().charAt(0);
        if(ch!='('&&ch!=')')
         out.append(ch);
        k--;
    }
}