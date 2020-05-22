struct InputData
{
    uint64_t in_size;
    uint8_t *data;
};

struct OutputData
{
    uint64_t out_size;
    uint8_t  *data;
};


OutputData* inputsToOutput(InputData** inputs, int numInputs)
{
    //Do whatever here to convert them..
    return NULL;
}


//Convert a Java inputData to C++ inputData
InputData* JavaInToCppIn(JNIEnv* env, jobject inputData)
{
    jclass cls = env->GetObjectClass(inputData);
    jlong in_size = env->GetLongField(inputData, env->GetFieldID(cls, "in_size", "J"));
    jarray arr = static_cast<jarray>(env->GetObjectField(inputData, env->GetFieldID(cls, "data", "[B")));
    jsize arrSize = env->GetArrayLength(arr);

    if (in_size != arrSize)
    {
        return NULL;
    }

    InputData* inData = new (std::nothrow) InputData();

    if (inData)
    {
        inData->in_size = in_size;
        inData->data = new (std::nothrow) uint8_t[arrSize];

        if (inData->data)
        {
            void* ptr = env->GetPrimitiveArrayCritical(arr, NULL);
            memcpy(inData->data, ptr, sizeof(uint8_t) * arrSize);
            env->ReleasePrimitiveArrayCritical(arr, ptr, 0);
            return inData;
        }

        delete inData;
    }
    return NULL;
}

//Convert a Java OutputData to C++ OutputData
OutputData* JavaOutToCppOut(JNIEnv* env, jobject outputData)
{
    jclass cls = env->GetObjectClass(outputData);
    jlong out_size = env->GetLongField(outputData, env->GetFieldID(cls, "out_size", "J"));
    jarray arr = static_cast<jarray>(env->GetObjectField(outputData, env->GetFieldID(cls, "data", "[B")));
    jsize arrSize = env->GetArrayLength(arr);

    if (out_size != arrSize)
    {
        return NULL;
    }

    OutputData* outData = new (std::nothrow) OutputData();

    if (outData)
    {
        outData->out_size = out_size;
        outData->data = new (std::nothrow) uint8_t[arrSize];

        if (outData->data)
        {
            void* ptr = env->GetPrimitiveArrayCritical(arr, NULL);
            memcpy(outData->data, ptr, sizeof(uint8_t) * arrSize);
            env->ReleasePrimitiveArrayCritical(arr, ptr, 0);
            return outData;
        }

        delete outData;
    }
    return NULL;
}

//Convert a C++ InputData to Java InputData
jobject CppInToJavaIn(JNIEnv* env, InputData* inData)
{
    jclass cls = env->FindClass("Lpackage/Name/InputData;");
    jobject res = env->NewObject(cls, env->GetMethodID(cls, "<init>", "()V"));
    env->SetLongField(res, env->GetFieldID(cls, "in_size", "J"), inData->in_size);

    jbyte* ptr = reinterpret_cast<jbyte*>(inData->data);
    jbyteArray arr = env->NewByteArray(inData->in_size);
    env->SetByteArrayRegion(arr, 0, inData->in_size, ptr);
    env->SetObjectField(res, env->GetFieldID(cls, "data", "[B"), arr);

    return res;
}

//Convert a C++ OutputData to a Java OutputData
jobject CppOutToJavaOut(JNIEnv* env, OutputData* outData)
{
    jclass cls = env->FindClass("Lpackage/Name/OutputData;");
    jobject res = env->NewObject(cls, env->GetMethodID(cls, "<init>", "()V"));
    env->SetLongField(res, env->GetFieldID(cls, "out_size", "J"), outData->out_size);

    jbyte* ptr = reinterpret_cast<jbyte*>(outData->data);
    jbyteArray arr = env->NewByteArray(outData->out_size);
    env->SetByteArrayRegion(arr, 0, outData->out_size, ptr);
    env->SetObjectField(res, env->GetFieldID(cls, "data", "[B"), arr);

    return res;
}


//Get Inputs from an ArrayList, convert them to an OutputData.
JNIEXPORT jobject JNICALL JAVA_package_name_getOutData(JNIEnv *env, jclass clazz,  jobject inputDatas)
{
    jclass arrayListClass = env->FindClass("Ljava/util/ArrayList;");
    int arrayListSize = env->CallIntMethod(inputDatas, env->GetMethodID(arrayListClass, "size", "()I"));

    if (arrayListSize > 0)
    {
        //Array of C++ inputs from Java..
        InputData** inputs = new (std::nothrow) InputData*[arrayListSize];

        if (inputs)
        {
            for (int i = 0; i < arrayListSize; ++i)
            {
                jobject jinput = env->NewGlobalRef(env->CallObjectMethod(inputDatas, env->GetMethodID(arrayListClass, "get", "(I)Ljava/lang/Object;"), i));

                inputs[i] = JavaInToCppIn(env, jinput);

                env->DeleteGlobalRef(jinput);
            }

            //Conver the C++ inputs to a C++ output, and then convert that C++ output into a Java OutputData.
            OutputData* out = inputsToOutput(inputs, arrayListSize);
            jobject output = CppOutToJavaOut(env, out);


            //Clean-Up.
            for (int i = 0; i < arrayListSize; ++i)
            {
                if (inputs[i])
                {
                    delete[] inputs[i]->data;
                }
                delete inputs[i];
            }

            delete[] inputs;
            delete out;

            return output;
        }
    }
    return NULL;
}