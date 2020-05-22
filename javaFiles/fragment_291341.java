public class Application
{
    public static void main(String [] args)
    {
        DerivedDataset1 dataset = new DerivedDataset1();
        BaseMeasure<DerivedDataset1> measure = new DerivedMeasure1();
        SocialNetworkBuilder socialNetworkBuilder = new SocialNetworkBuilder();
        socialNetworkBuilder.build(dataset, measure);
    }
}