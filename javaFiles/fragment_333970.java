int pos = -1;
...
for (int i=0;uL.length; i++)
{
    if(user.equals(uL[i])) { pos=i; break; }
}
...
if(pos==-1)
{
    // user not found
} else {
    // test the pass with pos as index
}