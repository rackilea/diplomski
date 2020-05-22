UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
UserAgent ua = parser.parse(anyUserAgentString);
if (ua.getKnownFragments().contains(KnownFragments.GT_P1000M)) {
    System.out.println("Seems to be a Galaxy Tab GT-P1000.");
} else if (ua.getKnownFragments().contains(KnownFragments.IPAD)) {
    System.out.println("Seems to be an iPad.");
} else if (ua.getKnownFragments().contains(KnownFragments.IPHONE)) {
    System.out.println("Seems to be an iPhone.");
}