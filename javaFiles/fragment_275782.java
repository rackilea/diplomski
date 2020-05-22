public static void main(String[] args) {

    // Original requirement
    System.out.println(getMap("%{orgCity} to %{destCity}", "delhi to goa"));

    // A variation with two words values
    System.out.println(getMap("%{orgCity} to %{destCity}", "New York to Mexico"));

    // Another variation
    System.out.println(getMap("%{orgCity} to %{destCity} and more", "delhi to goa and more"));

    // order of words doesn't matter
    System.out.println(getMap("%{orgCity} %{destCity} to", "delhi goa to"));

    // different strings than the original requirement
    System.out.println(getMap("I'm going to %{firstCity} and then to %{secondCity}", "I'm going to Nauru and then to Seattle"));

    // more than two values, with more than one word
    System.out.println(getMap("I am %{age} years old, I have %{eyesColour} eyes and %{pocketContent} in my pocket",
              "I am 20 years old, I have dark blue eyes and two coins in my pocket"));

    // etc ...
}