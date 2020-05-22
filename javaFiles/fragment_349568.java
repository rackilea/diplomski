public class SampleObserver implements FieldListener {

    @Override
    public void fieldValueChanged(String fieldName, Object newValue) {
        System.out.println(fieldName + " - got set with value - " + newValue);
    }

}