public int prepare (long id, Serializable o) {
        Context ctx = (Context) o;
        String url = getURL (ctx);
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(ctx.getString(JSON_REQUEST.name()),ContentType.create("application/json", Consts.UTF_8));
        post.setEntity(entity);

        try {
            client.execute(post, response -> {
                int sc = response.getStatusLine().getStatusCode();
                if (sc == HttpStatus.SC_CREATED || sc == HttpStatus.SC_OK)
                    ctx.put (JSON_RESPONSE.name(), EntityUtils.toString(response.getEntity()));
                ctx.resume();
                return null;
            });
            return PREPARED | PAUSE | NO_JOIN | READONLY;
        } catch (IOException e) {
            warn (e);
        }
        return ABORTED;
    }