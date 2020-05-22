final int[] value = new int[1];
            pollExecutor.scheduleWithFixedDelay(new Runnable() {

                Map<String, String> statMap = null;

                @Override
                public void run() {

                    try {
                        statMap = coldService.doPoll(id);
                    } catch (Exception e) {

                    }
                    if (statMap != null) {
                        for (Map.Entry<String, String> entry : statMap
                                .entrySet()) {
                            if ("failed".equals(entry.getValue())) {
                                value[0] = 2;

                                pollExecutor.shutdown();
                            }
                        }
                    }
                }

            }, 0, 5, TimeUnit.MINUTES);
            try {
                pollExecutor.awaitTermination(40, TimeUnit.MINUTES);
            } catch (InterruptedException e) {

            }