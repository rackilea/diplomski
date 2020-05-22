Flowable<ByteBuffer<?>> responseFlowable = myClient.getQueryResult("job1", "foo")
int sum = 0
responseFlowable.blockingForEach { ByteBuffer byteBuffer ->
    sum += byteBuffer.toByteArray().count('!')
    ((ReferenceCounted)byteBuffer).release() // Let Netty do its thing!
}