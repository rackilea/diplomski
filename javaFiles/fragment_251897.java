jbyte* d = (*env)->GetByteArrayElements(env, b, &isCopyS);

int i;

for(i = 0; i < srcLen; i++)
{
    data[i] = d[i];
}

(*env)->ReleaseByteArrayElements(env, b, d, JNI_ABORT);