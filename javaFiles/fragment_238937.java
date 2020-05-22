jclass arrayListClass = env->FindClass("java/util/ArrayList"); // Find ArrayList class
jmethodID constructor = env->GetMethodID(arrayListClass, "<init>", "()V"); // Find ArrayList constructor
jobject arrayList = env->NewObject(arrayListClass, constructor); // Create new ArrayList instance
jmethodID add = env->GetMethodID(arrayListClass, "add", "(Ljava/lang/Object;)Z"); // Find the ArrayList::add method
jbyteArray item =env->NewByteArray(10); // Instantiate a new byte[]
env->CallBooleanMethod(arrayList, add, item); // Add the byte[] to the ArrayList