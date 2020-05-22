parameterTable.where().top(1000).execute(new TableQueryCallback<Parameter>()
            @Override
            public void onCompleted(List<Parameter> result, int count,
                    Exception exception, ServiceFilterResponse response) {
                if (exception != null) {
                    Log.e(TAG, exception.getCause().getMessage());
                    return;
                }
                for(Parameter p : result){
                    parameterList.add(p);
                }
                Intent broadcast = new Intent();
                broadcast.setAction("tables.loaded");
                Shared.sendBroadcast(broadcast);
            }
        });