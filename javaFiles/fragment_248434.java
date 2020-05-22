JNIEXPORT void JNICALL Java_org_opencv_samples_tutorial3_Sample3View_Test(JNIEnv* env, jobject thiz, 
jint width, jint height, jbyteArray p_data, jintArray bgra)
{

jbyte* _p_data= env->GetByteArrayElements(p_data, 0);
jint* _bgra = env->GetIntArrayElements(bgra, 0);

Mat mdata(height, width, CV_8UC4, (unsigned char *)_p_data);
Mat mbgra(height, width, CV_8UC4, (unsigned char *)_bgra);


Mat tmp_mat= imdecode(mdata,1);
cvtColor(tmp_mat, mbgra, CV_RGB2RGBA);

env->ReleaseIntArrayElements(bgra, _bgra, 0);
env->ReleaseByteArrayElements(p_data, _p_data, 0);
}