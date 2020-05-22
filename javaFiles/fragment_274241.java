int count = packages.Call<int>("size"); //getting the size of the array

for( int i = 0; i < count; i++ )
{
 //getting the object at location i
 AndroidJavaObject currentObject = packages.Call("get", i );

 //use currentObject using the same methods as before: Call, CallStatic, Get, GetStatic
}