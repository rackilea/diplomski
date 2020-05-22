private static void dangerousSpeakAndFly(Object x) {
    if (x instanceof Speakable) {
        Speakable temp  = (Speakable) x;
        temp.Speak();
    }
    if (x instanceof Flyer) {
        Flyer temp2= (Flyer) x;
        temp2.Fly();
    }
}