final AccessRequest challengeResponseRequest = new AccessRequest(
            USER,
            PASSCODE
);

challengeResponseRequest.addAttribute(
    new RadiusAttribute(24, packet.getAttribute(24).getAttributeData()) // GOOD
);