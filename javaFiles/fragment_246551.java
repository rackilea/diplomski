extern "C" JNIEXPORT jobject JNICALL Java_com_example_examplefunction(
    JNIEnv* env, jclass* class_){

    //Get class identifier of our object
    jclass cls = env->FindClass("com/example/ObjectTransform");

    //Get constructor identifier for our object
    jmethodID constructor = env->GetMethodID(cls,"<init>","()V");

    //Get field identifiers of our object
    //Transform is a two dimensional double array, denoted as [[D
    jfieldID nameID = env->GetFieldID(cls,"name","Ljava/lang/String;");
    jfieldID transformID = env->GetFieldID(cls,"transform","[[D"); 

    //Allocate object that we will return
    jobject jresult = env->NewObject(cls, constructor);

    //Set object name
    env->SetObjectField(jresult, nameID, env->NewStringUTF("some name"));

    /*
     * Build object transform matrix
     */

    //Get rows of the matrix in JVM heap space, we will change them
    jobjectArray rows = reinterpret_cast<jobjectArray>(
        env->GetObjectField(jresult,transformID));

    //Allocate some temporary variables
    jdoubleArray jrow;
    jdouble row[4];

    //Traverse rows
    for(int j=0;j<4;j++){

        //Traverse columns
        for(int k=0;k<4;k++){

            //Set current element of the matrix accordingly
            row[k] = calculate_some_value(j,k);
        }

        //Temporarily allocate a new row in JVM heap space 
        //No need to unpin an array allocated with New...Array in the end
        jrow = env->NewDoubleArray(4);

        //Fill the newly allocated row
        env->SetDoubleArrayRegion(jrow,0,4,row);

        //Write the newly filled row to the appropriate row of our matrix
        env->SetObjectArrayElement(rows,j,jrow);
    }

    return jresult;
}