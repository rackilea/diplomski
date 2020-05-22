int main()
{
    ::android::hardware::configureRpcThreadpool(1, true);
    ::android::sp<MyHal> service = new MyHal;
    if (::android::OK != service->registerAsService())
        return EXIT_FAILURE;
    ::android::hardware::joinRpcThreadpool();
    return EXIT_SUCCESS;
}