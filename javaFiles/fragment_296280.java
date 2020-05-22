public Object doInTransaction(){
                TestAO testAO = ao.get(TestAO.class,issueXXX.getId());
                testAO.setError(issueXXX.getError());
                testAO.save();
                return null;
            }