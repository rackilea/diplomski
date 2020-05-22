JNIEXPORT jintArray JNICALL Java_NativeRandom_generateRandomIntegers(JNIEnv *env, jclass cls, int size)
{
    std::vector<int> integers(size);
    std::iota(std::begin(integers), std::end(integers), 0);

    std::mt19937 gen;
    gen.seed(size);
    std::shuffle(std::begin(integers), std::end(integers), gen);


    jintArray result = env->NewIntArray(size);
    if (result)
    {
        env->SetIntArrayRegion(result, 0, size, &integers[0]);
        return result;
    }
    return nullptr;
}