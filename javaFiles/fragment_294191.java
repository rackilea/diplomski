//these classes and methods should be public (also in Dog)
public class GreatDane extends Dog {
    public GreatDane() {
        mSize = new String[]{"tiny","small","average","large","huge"};
    }

    @Override
    public void feed(){
        mFeedCounter++;//incrementing inside other statements is concise but discouraged
        if (mFeedCounter == 3) { //consider >= 3 just in case
            dogSize++;
            getSize();
            mFeedCounter = 0;
        }
    }
}