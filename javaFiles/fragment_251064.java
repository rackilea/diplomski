BatchRequest batch = MirrorClient.getMirror(null).batch();
BatchCallback callback = new BatchCallback();

for (TimelineItem item : items) {
        MirrorClient.getMirror(userCredential).timeline().insert(item).queue(batch, callback);
}

batch.execute();