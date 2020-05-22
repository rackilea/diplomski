public class MyTestWatcher extends TestWatcher {
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                List<Throwable> errors = new ArrayList<Throwable>();

                startingQuietly(description, errors);
                try {
                    base.evaluate();
                    succeededQuietly(description, errors);
                }
                catch (NoSuchElementException e) {
                    // ignore this
                }
                catch (AssumptionViolatedException  e) {
                    errors.add(e);
                    skippedQuietly(e, description, errors);
                }
                catch (Throwable e) {
                    errors.add(e);
                    failedQuietly(e, description, errors);
                }
                finally {
                    finishedQuietly(description, errors);
                }

                MultipleFailureException.assertEmpty(errors);
            }
        };
    }