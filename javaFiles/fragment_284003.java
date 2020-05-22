watcherExecutor.execute(new Runnable(){
                        public void run() {
                           // publish a new bid event to a watcher
                           aCtx.getResponse().getWriter().print("A new bid on the item was placed. The current price ..., next bid price is ...");
                           aCtx.complete();
                        };
                     });