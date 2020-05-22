try {
        Thread.sleep(500);
    } catch (Exception e) {
    } finally {
        low.stop();
        hi.stop();
    }