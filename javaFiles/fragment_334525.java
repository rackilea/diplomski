try {
        result = new httprRequest().execute().get();
        // A work around to fix the problem
        if(internet avialable) {
            HRdb.delete("HRinfotbl", null, null);
        } else { 
            getData();
        }
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }