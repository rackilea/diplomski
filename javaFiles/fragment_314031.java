JNIEXPORT void JNICALL Java_com_voidseer_voidengine_mesh_Vertices_PutFloatsJni
(JNIEnv *env, jclass, jfloatArray src, jobject dst, jint numFloats, jint dstOffset )
{
        float* pDst = (float*)env->GetDirectBufferAddress( dst );
        float* pSrc = (float*)env->GetPrimitiveArrayCritical(src, 0);

        //memcpy( pDst + (dstOffset << 2), pSrc, numFloats << 2 );
        memcpy( &pDst[dstOffset], pSrc, sizeof(float) * numFloats );

        env->ReleasePrimitiveArrayCritical(src, pSrc, 0);
}