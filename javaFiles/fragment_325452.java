abstract class AbstractTrainFactory<T extends Train> {
    protected abstract T newTrainInstance();
    public abstract T fashionTrainToSpec();
}

abstract class AbstractBulletTrainFactory<T extends BulletTrain>
extends AbstractTrainFactory<T> {
    @Override
    public T fashionTrainToSpec() {
        T theTrain = newTrainInstance();
        theTrain.noseSwoop = noseSwoopSpec;
        return theTrain;
    }
}

class FastBulletTrainFactory
extends AbstractBulletTrainFactory<FastBulletTrain> {
    @Override
    protected FastBulletTrain newTrainInstance() {
        return new FastBulletTrain();
    }
}