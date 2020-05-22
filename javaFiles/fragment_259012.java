client.statusChanged().subscribe(new Action1<WampClient.State>() {
        @Override
        public void call(WampClient.State t1) {
            if (t1 instanceof WampClient.ConnectedState) {
                subscription = client.makeSubscription("trollbox")
                        .subscribe((s) -> { System.out.println(s.arguments()); }
            }
        }
    });
    client.open();