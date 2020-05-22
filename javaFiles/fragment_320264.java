Array return_objs = ocs.getArray(1);

Clob[] clobs = (Clob[]) return_objs.getArray();

return_objs.free();

for(int i = 0; i < clobs.length; i++ )
{
    //Utilize clob

    clobs[i].free();
}