public class mSubtitleDecoderFactory implements SubtitleDecoderFactory{

    @Override
    public boolean supportsFormat(Format format) {
        return SubtitleDecoderFactory.DEFAULT.supportsFormat(format);
    }

    @Override
    public SubtitleDecoder createDecoder(Format format){
        SubtitleDecoder wrapped = SubtitleDecoderFactory.DEFAULT.createDecoder(format);
        SubtitleDecoder wrapper = new SubtitleDecoder() {

            @Override
            O dequeueOutputBuffer() throws E {
                O resultFromWrapped = wrapped.dequeueOutputBuffer()
                // Do what you want with resultFromWrapped and return it modified
            }

            @Override
            String getName() {
                return wrapped.getName();
            }

            @Override
            void queueInputBuffer(I inputBuffer) throws E {
                wrapped.queueInputBuffer(inputBuffer);
            }

            // Delegate all other methods

        };
        return wrapper
    }

}