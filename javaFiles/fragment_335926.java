void doSomethingWithJCuda()
{
    CUdeviceptr data = new CUdeviceptr();
    cuMemAlloc(data, 1000);

    workWith(data);

    // *(See notes below)
}