jdoubleArray in2 = env->NewDoubleArray(1000);
jboolean isCopy;
jdouble *elems2 = env->GetDoubleArrayElements(in2, &isCopy);
for(int i = 0; i < 1000; i++)
{
    elems2[i] = (jdouble)inputArray[i];
}
env->ReleaseDoubleArrayElements(in2, elems2, 0);
elems2 = NULL;