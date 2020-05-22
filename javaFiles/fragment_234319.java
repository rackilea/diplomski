public class FactoryImpl implements GenericFactory<I> {
     @override
     I buildInstance() {
        return new impl();
     }
}