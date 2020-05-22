int highestCount = 0;
String mostEnteredProductType = null;
for (int i = 0; i < NUM_DRINKS; i++) {
    // Once we reach a null productType, we have reached the end of the
    // entered productTypes
    if (productTypes[i] == null) {
        break;
    } else if (counts[i] > highestCount) {
        highestCount = counts[i];
        mostEnteredProductType = productTypes[i];
    }
}

// Should probably check that mostEnteredProductType isn't null here.
System.out.println(mostEnteredProductType + " was the most ordered product.");