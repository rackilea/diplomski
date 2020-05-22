try {
    String questionId = (String) mExpression.evaluate(mJexlContext);
} catch (JexlException e) {
    Exception original = e.getCause();
    // do something with the original
}