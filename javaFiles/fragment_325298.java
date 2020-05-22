jclass cCharSequence = env->FindClass("java/lang/CharSequence");
jmethodID mLength = env->GetMethodID(cCharSequence, "length", "()I");
jmethodID mCharAt = env->GetMethodID(cCharSequence, "charAt", "(I)C");

int length = env->CallIntMethod(mid, mLength);
std::string str;
str.reserve(length);
for(int i = 0; i < length; i++) {
    str += env->CallCharMethod(mid, mCharAt, i);
}

// use 'str.c_str()'...