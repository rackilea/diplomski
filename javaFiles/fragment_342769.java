while(st.hasMoreTokens() )
{
    array[i] = st.nextToken();
    if(st.hasMoreTokens()) // check again whether the next toaken is available or not
        array[(i+1)] = st.nextToken();
    i++;
}