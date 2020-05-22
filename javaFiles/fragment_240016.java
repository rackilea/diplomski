jlong Java_xxx_getNativeRef(...)
{
    std::shared_ptr<MyObject> *pNew = new std::shared_ptr<MyObject>;
    *pNew = whatever-you-do to obtain an std::shared_ptr<MyObject>;
    return reinterpret_cast<jlong>(pNew);
}

Java_xxx_releaseNativeRef(..., jlong nativeRef)
{
    std::shared_ptr<MyObject> *pSp = reinterpret_cast<std::shared_ptr<MyObject> *>(nativeRef);
    delete *pSp;
    delete pSp; // thanks @LucasZanella
}