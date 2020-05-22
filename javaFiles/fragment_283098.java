// connect attempts to connect a client API to the IGraphicBufferProducer.
// This must be called before any other IGraphicBufferProducer methods are
// called except for getAllocator.
//
// This method will fail if the connect was previously called on the
// IGraphicBufferProducer and no corresponding disconnect call was made.
//
// outWidth, outHeight and outTransform are filled with the default width
// and height of the window and current transform applied to buffers,
// respectively. The token needs to be any binder object that lives in the
// producer process -- it is solely used for obtaining a death notification
// when the producer is killed.
virtual status_t connect(const sp<IBinder>& token,
        int api, bool producerControlledByApp, QueueBufferOutput* output) = 0;