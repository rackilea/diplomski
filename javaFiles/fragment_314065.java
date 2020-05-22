@Override
public int compareTo(MedalsOfCountry medals) {
    return Comparator.comparingInt(MedalsOfCountry::getGoldCount)
        .thenComparingInt(MedalsOfCountry::getSilverCount)
        .thenComparingInt(MedalsOfCountry::getBronzeCount)
        .compare(this, medals);
}