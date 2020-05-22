public static ResultObject my(int a, int b)
{
ResultObject resObject = new ResultObject();
resObject.c = a + b;

resObject.d = a*b;

resObject.e = a-b;

resObject.f = a/b;
return resObject;
}