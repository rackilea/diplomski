for (int i=0; i<n; i++) {
            Work w = new Work(i);
            Future<int[]> future =executor.submit(w);
            int[] y;
            try
            {
                y = future.get();
                if (y != null) {
                    result.add(y);
                }
            } catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }

        }