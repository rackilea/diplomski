String termsAndConditions = getResources().getString(R.string.terms_and_conditions);
String privacyPolicy = getResources().getString(R.string.privacy_policy);

legalDescription.setText(
    String.format(
        getResources().getString(R.string.message),
        termsAndConditions,
        privacyPolicy)
);
legalDescription.setMovementMethod(LinkMovementMethod.getInstance());

Pattern termsAndConditionsMatcher = Pattern.compile(termsAndConditions);
Linkify.addLinks(legalDescription, termsAndConditionsMatcher, "terms:");

Pattern privacyPolicyMatcher = Pattern.compile(privacyPolicy);
Linkify.addLinks(legalDescription, privacyPolicyMatcher, "privacy:");