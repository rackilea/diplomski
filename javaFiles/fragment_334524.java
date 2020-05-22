try {
        result = new httprRequest().execute().get();

        HRdb.delete("HRinfotbl", null, null);// This cause the problem.

    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }