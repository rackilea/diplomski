Observable.create(SyncOnSubscribe.createStateful(
    () -> new FileInputStream("file.dat")
    (in, out) -> {
        byte[] buf = new byte[4096];
        int r = in.read(buf);
        if (r < 0) {
            out.onCompleted();
        } else {
            if (r == buf.length) {
                out.onNext(buf);
            } else {
                byte[] buf2 = new byte[r];
                System.arraycopy(buf, 0, buf2, 0, r);
                out.onNext(buf2);
            }
        }

    }, 
    in -> in.close()
));